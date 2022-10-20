package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.EducationCreateRequest;
import com.appcent.cvbuilder.controller.request.update.EducationUpdateRequest;
import com.appcent.cvbuilder.model.Education;

public interface EducationService {
    
    List<Education> getEducationByCvId(Long cvId);
    Education create(EducationCreateRequest educationCreateRequest);
    Education update(EducationUpdateRequest educationUpdateRequest);
    Boolean delete(Long id);
   
    Education getEducation(Long id);
}
