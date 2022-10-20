package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.controller.request.create.EducationCreateRequest;
import com.appcent.cvbuilder.controller.request.update.EducationUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Education;
import com.appcent.cvbuilder.repository.EducationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationImpl implements EducationService{
    
    private final EducationRepository educationRepository;

    private final CVInfoService cvInfoService;

    @Override
    public List<Education> getEducationByCvId(Long cvId) {
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        return educationRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Education create(EducationCreateRequest educationCreateRequest) {
        if(!cvInfoService.existByCvId(educationCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        Education newEducation = Education.builder()
                                    .startDate(educationCreateRequest.getStartDate())
                                    .cvId(educationCreateRequest.getCvId())
                                    .endDate(educationCreateRequest.getEndDate())
                                    .isStillStudent(educationCreateRequest.getIsStillStudent())
                                    .educationLevelId(educationCreateRequest.getEducationLevelId())
                                    .educationDepartmentId(educationCreateRequest.getEducationDepartmentId())
                                    .universityId(educationCreateRequest.getUniversityId())
                                    .build();

        return educationRepository.save(newEducation);
    }

    @Override
    public Education update(EducationUpdateRequest educationUpdateRequest) {
        if(!educationRepository.existsById(educationUpdateRequest.getEducationId())){
            throw new CvBusinessException("CV-1016","Education not found",HttpStatus.NOT_FOUND);
        }

        Education updateEducation = educationRepository.findById(educationUpdateRequest.getEducationId()).orElse(null);
        updateEducation.setStartDate(educationUpdateRequest.getStartDate());
        updateEducation.setEndDate(educationUpdateRequest.getEndDate());
        updateEducation.setIsStillStudent(educationUpdateRequest.getIsStillStudent());
        updateEducation.setEducationLevelId(educationUpdateRequest.getEducationLevelId());
        updateEducation.setEducationDepartmentId(educationUpdateRequest.getEducationDepartmentId());
        updateEducation.setUniversityId(educationUpdateRequest.getUniversityId());

        return educationRepository.save(updateEducation);
    }

    @Override
    public Boolean delete(Long id) {
        if(!educationRepository.existsById(id)){
            throw new CvBusinessException("CV-1016","Education not found",HttpStatus.NOT_FOUND);
        }
        educationRepository.deleteById(id);
        return true;
    }

    @Override
    public Education getEducation(Long id) {
        if(!educationRepository.existsById(id)){
            throw new CvBusinessException("CV-1016","Education not found",HttpStatus.NOT_FOUND);
        }
        return educationRepository.findById(id).orElse(null);
        
    }

    
}
