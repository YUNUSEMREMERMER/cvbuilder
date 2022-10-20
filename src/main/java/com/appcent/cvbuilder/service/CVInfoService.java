package com.appcent.cvbuilder.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.appcent.cvbuilder.controller.request.create.CVInfoCreateRequest;
import com.appcent.cvbuilder.controller.request.update.CVInfoUpdateRequest;
import com.appcent.cvbuilder.controller.response.ImageUploadResponse;
import com.appcent.cvbuilder.model.CVInfo;

@Service
public interface CVInfoService {
    
    CVInfo getCVInformation(Long id);
    List<CVInfo> getCVInformations(Long userId);
    List<CVInfo> getCVInformations();
    CVInfo create(CVInfoCreateRequest cvInfoCreateRequest) throws IOException;
    CVInfo update(CVInfoUpdateRequest cvInfoUpdateRequest);
    Boolean delete(Long id);
    ImageUploadResponse updateImage(Long cvId,MultipartFile image) throws IOException;

    Boolean existByCvId(Long cvId);
 }
