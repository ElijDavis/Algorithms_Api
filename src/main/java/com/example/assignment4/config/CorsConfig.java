package com.example.assignment4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000", "https://algorithms-api.onrender.com", "https://portfolio-zeta-lemon-73.vercel.app") // TS dev server
                .allowedMethods("*");
    }
}
