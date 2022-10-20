package com.appcent.cvbuilder.service.storage;

import java.io.IOException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.appcent.cvbuilder.exception.CvBusinessException;

public interface FileService {
    String uploadImage(MultipartFile image) throws IOException;

    Boolean deleteFile(String path);

    default String generateFileName(String originalFileName) {
        return UUID.randomUUID().toString();
    }

    default String getExtension(String originalFileName) {
        return StringUtils.getFilenameExtension(originalFileName);
    }

    default boolean isSupportedContentType(String contentType) {
        return contentType.equals("image/png")
                || contentType.equals("image/jpg")
                || contentType.equals("image/jpeg");
    }

    default boolean isValidContentType(MultipartFile file){
        String contentType = file.getContentType();
        if (!isSupportedContentType(contentType)) {
            throw new CvBusinessException("CV-1070", "Only PNG or JPG images are allowed", HttpStatus.BAD_REQUEST);
        }
        return true;
    }
    
}
