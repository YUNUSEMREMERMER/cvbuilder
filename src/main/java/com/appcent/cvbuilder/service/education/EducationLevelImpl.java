package com.appcent.cvbuilder.service.education;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.education.EducationLevel;
import com.appcent.cvbuilder.repository.education.EducationLevelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EducationLevelImpl implements EducationLevelService{
    
    private final EducationLevelRepository educationLevelRepository;
    @Override
    public EducationLevel getEducationLevel(Long id) {
        if(!this.educationLevelRepository.existsById(id)){
            throw new CvBusinessException("CV-1001", "Education Level Not Found", HttpStatus.NOT_FOUND);
        }
        return this.educationLevelRepository.findById(id).orElse(null);
    }

    @Override
    public List<EducationLevel> getEducationLevels() {
        return this.educationLevelRepository.findAll();
    }

    @Override
    public EducationLevel create(EducationLevel EducationLevel) {
        return this.educationLevelRepository.save(EducationLevel);
    }

    @Override
    public EducationLevel update(EducationLevel EducationLevel) {
        if(!this.educationLevelRepository.existsById(EducationLevel.getLevelId())){
            throw new CvBusinessException("CV-1001","Education Level Not Found",HttpStatus.NOT_FOUND);
        }
        return this.educationLevelRepository.save(EducationLevel);
    }

    @Override
    public Boolean delete(Long id) {
        if(!this.educationLevelRepository.existsById(id)){
            throw new CvBusinessException("CV-1001","Education Level Not Found",HttpStatus.NOT_FOUND);
        }
        this.educationLevelRepository.deleteById(id);
        return true;
    }
    
}
