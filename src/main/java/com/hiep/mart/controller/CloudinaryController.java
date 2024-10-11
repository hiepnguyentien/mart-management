package com.hiep.mart.controller;

import com.hiep.mart.service.impl.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class CloudinaryController {

    private final CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Map<String, Object> result = cloudinaryService.uploadImage(file);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(Map.of("error", "Unable to upload image"));
        }
    }

    @DeleteMapping("/delete/{publicId}")
    public ResponseEntity<String> deleteImage(@PathVariable String publicId) {
        try {
            boolean deleted = cloudinaryService.deleteImage(publicId);
            if (deleted) {
                return ResponseEntity.ok("Image deleted successfully");
            } else {
                return ResponseEntity.status(404).body("Image not found");
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error deleting image");
        }
    }
}
