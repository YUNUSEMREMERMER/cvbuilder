package com.appcent.cvbuilder.service.experience;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.experience.JobPosition;
import com.appcent.cvbuilder.repository.experience.JobPositionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobPositionImpl implements JobPositionService{
    
    private final JobPositionRepository jobPositionRepository;

    @Override
    public JobPosition getJobPosition(Long id) {
        if(!jobPositionRepository.existsById(id)){
            throw new CvBusinessException("CV-1009","Position not found",HttpStatus.NOT_FOUND);
        }
        return jobPositionRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobPosition> getJobPositions() {
        
        return jobPositionRepository.findAll();
    }

    @Override
    public JobPosition create(JobPosition JobPosition) {
        
        return jobPositionRepository.save(JobPosition);
    }

    @Override
    public JobPosition update(JobPosition jobPosition) {
        
        if(!jobPositionRepository.existsById(jobPosition.getPositionId())){
            throw new CvBusinessException("CV-1009","Position not found",HttpStatus.NOT_FOUND);
        }
        JobPosition newJobPosition = jobPositionRepository.findById(jobPosition.getPositionId()).orElse(null);
        newJobPosition.setPositionName(jobPosition.getPositionName());

        return jobPositionRepository.save(newJobPosition);
    }

    @Override
    public Boolean delete(Long id) {
        if(!jobPositionRepository.existsById(id)){
            throw new CvBusinessException("CV-1009","Position not found",HttpStatus.NOT_FOUND);
        }
        jobPositionRepository.deleteById(id);

        return true;
    }
    
    
}
