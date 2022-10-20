package com.appcent.cvbuilder.service;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.controller.request.create.ExperienceCreateRequest;
import com.appcent.cvbuilder.controller.request.update.ExperienceUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Experience;
import com.appcent.cvbuilder.repository.ExperienceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExperienceImpl implements ExperienceService{

    private final ExperienceRepository experienceRepository;
    private final CVInfoService cvInfoService;
    
    @Override
    public List<Experience> getExperiences(Long cvId) {
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        return this.experienceRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Experience create(ExperienceCreateRequest experienceCreateRequest) {
        if(!cvInfoService.existByCvId(experienceCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }

        Experience newExperience = Experience
                                            .builder()
                                            .companyName(experienceCreateRequest.getCompanyName())
                                            .startDate(experienceCreateRequest.getStartDate())
                                            .endDate(experienceCreateRequest.getEndDate())
                                            .jobDescription(experienceCreateRequest.getJobDescription())
                                            .isStillWorking(experienceCreateRequest.getIsStillWorking())
                                            .cvId(experienceCreateRequest.getCvId())
                                            .jobDepartmentId(experienceCreateRequest.getJobDepartmentId())
                                            .jobPositionId(experienceCreateRequest.getJobPositionId())
                                            .build();

        return this.experienceRepository.save(newExperience);
    }

    @Override
    public Experience update(ExperienceUpdateRequest experienceUpdateRequest) {
        if(!experienceRepository.existsById(experienceUpdateRequest.getExperienceId())){
            throw new CvBusinessException("CV-1040", "Experience not found", HttpStatus.NOT_FOUND);
        }

        Experience updateExperience = experienceRepository.findById(experienceUpdateRequest.getExperienceId()).orElse(null);
        updateExperience.setCompanyName(experienceUpdateRequest.getCompanyName());
        updateExperience.setStartDate(experienceUpdateRequest.getStartDate());
        updateExperience.setEndDate(experienceUpdateRequest.getEndDate());
        updateExperience.setJobDescription(experienceUpdateRequest.getJobDescription());
        updateExperience.setIsStillWorking(experienceUpdateRequest.getIsStillWorking());
        updateExperience.setJobDepartmentId(experienceUpdateRequest.getJobDepartmentId());
        updateExperience.setJobPositionId(experienceUpdateRequest.getJobPositionId());

        return this.experienceRepository.save(updateExperience);
    }

    @Override
    public Boolean delete(Long id) {
        if(!experienceRepository.existsById(id)){
            throw new CvBusinessException("CV-1040", "Experience not found", HttpStatus.NOT_FOUND);
        }
        this.experienceRepository.deleteById(id);
        return true;
    }

    @Override
    public Experience getExperience(Long id) {
        if(!experienceRepository.existsById(id)){
            throw new CvBusinessException("CV-1040", "Experience not found", HttpStatus.NOT_FOUND);
        }
        return this.experienceRepository.findById(id).orElse(null);

    }
   
}
