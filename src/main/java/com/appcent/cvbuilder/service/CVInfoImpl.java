package com.appcent.cvbuilder.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.appcent.cvbuilder.model.CVInfo;
import com.appcent.cvbuilder.repository.CVInfoRepository;
import com.appcent.cvbuilder.service.storage.FileService;
import com.appcent.cvbuilder.controller.request.create.CVInfoCreateRequest;
import com.appcent.cvbuilder.controller.request.update.CVInfoUpdateRequest;
import com.appcent.cvbuilder.controller.response.ImageUploadResponse;
import com.appcent.cvbuilder.exception.CvBusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CVInfoImpl implements CVInfoService{
    
    @Value("${firebase.image-path}")
    private String remoteImagePath;

    @Value("${firebase.image-url}")
    private String imageUrl;

    private final CVInfoRepository cvInfoRepository;
    private final FileService fileService;

    @Override
    public CVInfo getCVInformation(Long id) {
        if(!cvInfoRepository.existsById(id)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        return this.cvInfoRepository.findById(id).orElse(null);
    }

    @Override
    public List<CVInfo> getCVInformations() {
        return this.cvInfoRepository.findAll();
    }

    @Override
    public List<CVInfo> getCVInformations(Long userId) {
        return this.cvInfoRepository.findByUser_UserId(userId);
    }


    @Override
    public CVInfo create(CVInfoCreateRequest cvInfoCreateRequest) throws IOException{
        String picture = null;

        if(!cvInfoCreateRequest.getPicture().isEmpty()){
            picture = fileService.uploadImage(cvInfoCreateRequest.getPicture());
        }

        CVInfo newCVInfo = CVInfo.builder()
                                    .userId(cvInfoCreateRequest.getUserId())
                                    .name(cvInfoCreateRequest.getName())
                                    .surname(cvInfoCreateRequest.getSurname())
                                    .email(cvInfoCreateRequest.getEmail())
                                    .phone(cvInfoCreateRequest.getPhone())
                                    .picture(picture)
                                    .shortResume(cvInfoCreateRequest.getShortResume())
                                    .cvLink(cvInfoCreateRequest.getCvLink())
                                    .cityId(cvInfoCreateRequest.getCityId())
                                    .build();

        return this.cvInfoRepository.save(newCVInfo);
    }

    @Override
    public CVInfo update(CVInfoUpdateRequest cvInfoUpdateRequest) {
        if(!cvInfoRepository.existsById(cvInfoUpdateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        
        CVInfo updateCVInfo = cvInfoRepository.findById(cvInfoUpdateRequest.getCvId()).orElse(null);
        updateCVInfo.setName(cvInfoUpdateRequest.getName());
        updateCVInfo.setSurname(cvInfoUpdateRequest.getSurname());
        updateCVInfo.setEmail(cvInfoUpdateRequest.getEmail());
        updateCVInfo.setPhone(cvInfoUpdateRequest.getPhone());
        updateCVInfo.setShortResume(cvInfoUpdateRequest.getShortResume());
        updateCVInfo.setCvLink(cvInfoUpdateRequest.getCvLink());
        updateCVInfo.setCityId(cvInfoUpdateRequest.getCityId());

        return this.cvInfoRepository.save(updateCVInfo);
    }

    @Override
    public Boolean delete(Long id) {
        if(!cvInfoRepository.existsById(id)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }

        String oldImageName = this.getCVInformation(id).getPicture();
        if(oldImageName != null){
            fileService.deleteFile(remoteImagePath + oldImageName);
        }

        this.cvInfoRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean existByCvId(Long cvId) {
        if(!cvInfoRepository.existsById(cvId)){
            return false;
        }
        return true;
    }

    @Override
    public ImageUploadResponse updateImage(Long cvId,MultipartFile image) throws IOException {
        if(!cvInfoRepository.existsById(cvId)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }

        String oldImageName = this.getCVInformation(cvId).getPicture();
        if(oldImageName != null){
            fileService.deleteFile(remoteImagePath + oldImageName);
        }
        String fileName = fileService.uploadImage(image);
        CVInfo updateCVInfo = cvInfoRepository.findById(cvId).orElse(null);

        ImageUploadResponse imageUploadResponse = ImageUploadResponse.builder()
                                                                        .imageUrl(String.format(imageUrl, URLEncoder.encode(remoteImagePath+fileName, StandardCharsets.UTF_8)))
                                                                        .build();

        updateCVInfo.setPicture(fileName);
        cvInfoRepository.save(updateCVInfo);
        return imageUploadResponse;
    }

    
}
