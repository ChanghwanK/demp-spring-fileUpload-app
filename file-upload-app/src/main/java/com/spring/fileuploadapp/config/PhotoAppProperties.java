package com.spring.fileuploadapp.config;

import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * File Writer 에서 경로 생성 시 사용된다.
 *
 * @Created by Bloo
 * @Date: 2021/06/19
 */
@Slf4j
@Configuration
@Data
public class PhotoAppProperties {
    @Value("{FileUploadApp.file.defaultPath}")
    private String defaultPath;

    @PostConstruct
    private void init() {
        log.info("path:: {}",this.defaultPath);
    }

}
