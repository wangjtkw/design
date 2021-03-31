package com.example.design.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        /*
//         * windows
//         */
//        registry.addResourceHandler(MyFile.imgAccessPath).addResourceLocations("file:" + MyFile.uploadWindowImg);
//        registry.addResourceHandler(MyFile.pageAccessPath).addResourceLocations("file:" + MyFile.uploadWindowPage);

        /*
         * linux
         */
        registry.addResourceHandler(MyFile.imgAccessPath).addResourceLocations("file:" + MyFile.uploadLinuxImg);
        registry.addResourceHandler(MyFile.pageAccessPath).addResourceLocations("file:" + MyFile.uploadLinuxPage);

    }
}