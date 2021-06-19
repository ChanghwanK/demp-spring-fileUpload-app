package com.spring.fileuploadapp.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @Created by Bloo
 * @Date: 2021/06/19
 */
@Slf4j
@Configuration
public class MultipartConfig {
    @Value("${FileUploadApp.file.defaultPath}")
    public String defaultPath = "";

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setResolveLazily(true);
        multipartResolver.setMaxUploadSize(1024 * 1024 * 10);
        multipartResolver.setDefaultEncoding(StandardCharsets.UTF_8.displayName());

        try {
            log.info("path:" + defaultPath);
            multipartResolver.setUploadTempDir(new FileSystemResource(defaultPath));
        } catch ( IOException e ) {
            log.error("init error", e);
        }
        return multipartResolver;
    }
}
