package com.openvarsity.img.imgservice.client;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageServiceConfig {

    //API ENV VARIABLE
    //CLOUDINARY_URL=cloudinary://545169326766519:1n0dSR62F58bxyJWWfzd5PwEoQI@ambujtg

    @Bean
    public Cloudinary cloudinary(){
        final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ambujtg",
                "api_key", "545169326766519",
                "api_secret", "1n0dSR62F58bxyJWWfzd5PwEoQI"));
        return cloudinary;
    }

}
