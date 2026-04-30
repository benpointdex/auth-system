package com.henry.authBackendSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Serve static files (React app) from static/
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        Resource requestedResource = location.createRelative(resourcePath);
                        
                        // If the resource exists (e.g. JS, CSS, images), return it
                        if (requestedResource.exists() && requestedResource.isReadable()) {
                            return requestedResource;
                        }
                        
                        // If the resource doesn't exist and isn't an API call or Spring Security callback, 
                        // forward the request to React's index.html
                        if (!resourcePath.startsWith("api/") && 
                            !resourcePath.startsWith("oauth2/authorization/") && 
                            !resourcePath.startsWith("login/oauth2/")) {
                            return location.createRelative("index.html");
                        }
                        
                        return null;
                    }
                });
    }
}
