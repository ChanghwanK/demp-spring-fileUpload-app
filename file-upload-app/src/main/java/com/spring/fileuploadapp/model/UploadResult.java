package com.spring.fileuploadapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/06/19
 */

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadResult {

    private String fileId;
    private String fileName;
    private Long fileSize;
}
