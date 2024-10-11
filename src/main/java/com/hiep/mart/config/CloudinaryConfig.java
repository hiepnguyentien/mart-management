package com.hiep.mart.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "djmjp2now",
                "api_key", "676515853929181",
                "api_secret", "WKy93RxMaq_WCM14uvp-M3bt5Ug"
        ));
    }
}

