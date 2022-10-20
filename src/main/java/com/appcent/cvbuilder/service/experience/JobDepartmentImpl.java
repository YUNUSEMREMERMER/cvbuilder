package com.appcent.cvbuilder.service.experience;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.experience.JobDepartment;
import com.appcent.cvbuilder.repository.experience.JobDepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobDepartmentImpl implements JobDepartmentService{
    
    private final JobDepartmentRepository jobDepartmentRepository;

    @Override
    public JobDepartment getJobDepartment(Long id) {
        
        if(!jobDepartmentRepository.existsById(id)){
            throw new CvBusinessException("CV-1010","Job Department not found",HttpStatus.NOT_FOUND);
        }

        return jobDepartmentRepository.findById(id).orElse(null);

    }

    @Override
    public List<JobDepartment> getJobDepartments() {
        
        return jobDepartmentRepository.findAll();

    }


    @Override
    public JobDepartment create(JobDepartment JobDepartment) {
        
        return jobDepartmentRepository.save(JobDepartment);

    }

    @Override
    public JobDepartment update(JobDepartment JobDepartment) {
        
        if(!jobDepartmentRepository.existsById(JobDepartment.getDepartmentId())){
            throw new CvBusinessException("CV-1010","Job Department not found",HttpStatus.NOT_FOUND);
        }
        JobDepartment newJobDepartment = jobDepartmentRepository.findById(JobDepartment.getDepartmentId()).orElse(null);
        newJobDepartment.setDepartmentName(JobDepartment.getDepartmentName());

        return jobDepartmentRepository.save(newJobDepartment);

    }

    @Override
    public Boolean delete(Long id) {

        if(!jobDepartmentRepository.existsById(id)){
            throw new CvBusinessException("CV-1010","Job Department not found",HttpStatus.NOT_FOUND);
        }
        jobDepartmentRepository.deleteById(id);
        
        return true;
        
    }
    
}
