package com.backend.example.EmployeePortal.Cors;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
    public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173") // Allow requests from this origin
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
                    .allowedHeaders("*"); // Allow all headers
        }
    }

