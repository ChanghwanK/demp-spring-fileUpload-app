package com.spring.fileuploadapp;

import com.spring.fileuploadapp.model.ImageFile;
import com.spring.fileuploadapp.model.UploadResult;
import com.spring.fileuploadapp.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Created by Bloo
 * @Date: 2021/06/19
 */

@RequiredArgsConstructor
@RestController
public class ApiFileUploadController {

    private final FileUploadService uploadService;

    @PostMapping ("/v1.0/upload/image")
    public UploadResult transfer( @RequestParam ("userKey") String userKey, @RequestPart ("imageFile") MultipartFile multipartFile) {

        ImageFile imageFile = uploadService.upload(multipartFile);

        return UploadResult.builder()
            .fileName(imageFile.getFileName())
            .fileId(imageFile.getFileId())
            .fileSize(imageFile.getFileSize())
            .build();
    }
}
