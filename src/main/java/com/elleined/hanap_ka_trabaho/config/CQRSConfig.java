package com.elleined.hanap_ka_trabaho.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CQRSConfig implements WebMvcConfigurer {

    @Value("#{'${front-end-base-urls}'.split(',')}")
    private List<String> frontEndBaseURLS;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println(Arrays.toString(frontEndBaseURLS.toArray(new String[0])));
        registry.addMapping("/**")
                .allowedOrigins(frontEndBaseURLS.toArray(new String[0])) // Front end base url
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("Content-Type", "Authorization") // For JWT
                .allowCredentials(true)
                .maxAge(3600); // 1 hour
    }
}