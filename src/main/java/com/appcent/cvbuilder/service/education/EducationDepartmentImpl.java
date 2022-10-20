package com.appcent.cvbuilder.service.education;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.education.EducationDepartment;
import com.appcent.cvbuilder.repository.education.EducationDepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationDepartmentImpl implements EducationDepartmentService{
   
    private final EducationDepartmentRepository educationDepartmentRepository;
    
    @Override
    public EducationDepartment getEducationDepartment(Long id) {
        if(!this.educationDepartmentRepository.existsById(id)){
            throw new CvBusinessException("CV-1003", "Education Department Not Found", HttpStatus.NOT_FOUND);
        }
        return this.educationDepartmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<EducationDepartment> getEducationDepartments() {
        return this.educationDepartmentRepository.findAll();
    }

    @Override
    public EducationDepartment create(EducationDepartment educationDepartment) {
        return this.educationDepartmentRepository.save(educationDepartment);

    }

    @Override
    public EducationDepartment update(EducationDepartment educationDepartment) {
        if(!this.educationDepartmentRepository.existsById(educationDepartment.getDepartmentId())){
            throw new CvBusinessException("CV-1003","Education Department Not Found",HttpStatus.NOT_FOUND);
        }
        return this.educationDepartmentRepository.save(educationDepartment);
    }

    @Override
    public Boolean delete(Long id) {
        if(!this.educationDepartmentRepository.existsById(id)){
            throw new CvBusinessException("CV-1003","Education Department Not Found",HttpStatus.NOT_FOUND);
        }
        this.educationDepartmentRepository.deleteById(id);
        return true;
    }
    
}
