package com.spring.fileuploadapp.service;

import com.spring.fileuploadapp.model.FileWriter;
import com.spring.fileuploadapp.model.ImageFile;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Created by Bloo
 * @Date: 2021/06/19
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class FileUploadService {
    private final FileWriter fileWriter;

    public ImageFile upload( MultipartFile sourceFile) {
        String fileId = UUID.randomUUID().toString();
        String filePath = fileWriter.getFilePath(fileId, sourceFile);
        log.info("filePath:: {}", filePath );
        fileWriter.writeFile(sourceFile, filePath);

        return ImageFile.builder()
            .fileName(sourceFile.getName())
            .filePath(filePath)
            .fileId(fileId)
            .fileSize(sourceFile.getSize())
            .build();
    }
}
