package com.backend.example.EmployeePortal.Cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("di5mauk60")
    private String cloudinaryCloudName;
    @Value("589654359655941")
    private String cloudinaryApiKey;
    @Value("zY9SQD9xSrR47XIKpexqwkxYlWA")
    private String cloudinaryApiSecret;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary("cloudinary://" + cloudinaryApiKey + ":" + cloudinaryApiSecret + "@" + cloudinaryCloudName);
    }
}
