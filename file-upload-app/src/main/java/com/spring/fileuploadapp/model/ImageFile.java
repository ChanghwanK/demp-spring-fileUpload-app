package com.spring.fileuploadapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.AliasFor;

/**
 * @Created by Bloo
 * @Date: 2021/06/19
 */

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageFile {
    private String fileId;
    private Long fileSize;
    private String fileName;
    private String fileType;
    private String filePath;
}
