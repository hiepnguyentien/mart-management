package com.hiep.mart.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hiep.mart.config.CloudinaryConfig;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CloudinaryService {

    Cloudinary cloudinary;

    public Map<String, Object> uploadImage(MultipartFile file) throws IOException {
        File tempFile = convertToFile(file);
        Map<String, Object> uploadResult = cloudinary.uploader().upload(tempFile, ObjectUtils.emptyMap());
        tempFile.delete();
        return uploadResult;
    }

    private File convertToFile(MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("temp", file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(file.getBytes());
        }
        return tempFile;
    }

    public boolean deleteImage(String publicId) throws IOException {
        Map<String, Object> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        return result.get("result").equals("ok");
    }
}
