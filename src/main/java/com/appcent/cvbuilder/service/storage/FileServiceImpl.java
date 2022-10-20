package com.appcent.cvbuilder.service.storage;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    @Value("${firebase.image-url}")
    private String imageUrl;

    @Value("${firebase.image-path}")
    private String remoteImagePath;
    
    @Override
    public String uploadImage(MultipartFile image) throws IOException {
        isValidContentType(image);
        Bucket bucket = StorageClient.getInstance().bucket();
        String fileName = generateFileName(image.getOriginalFilename());
        bucket.create(remoteImagePath+fileName, image.getBytes(), image.getContentType());
        return fileName;
    }

    @Override
    public Boolean deleteFile(String path) {
        Bucket bucket = StorageClient.getInstance().bucket();
        bucket.get(path).delete();
        return true;
    }
    
    
}
