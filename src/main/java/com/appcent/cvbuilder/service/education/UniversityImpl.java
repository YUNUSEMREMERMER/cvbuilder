package com.appcent.cvbuilder.service.education;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.education.University;
import com.appcent.cvbuilder.repository.education.UniversityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UniversityImpl implements UniversityService{
    
    private final UniversityRepository universityRepository;
    
    @Override
    public University getUniversity(Long id) {
        if(!this.universityRepository.existsById(id)){
            throw new CvBusinessException("CV-1002", "University Not Found", HttpStatus.NOT_FOUND);
        }
        return this.universityRepository.findById(id).orElse(null);
    }

    @Override
    public List<University> getUniversities() {
        return this.universityRepository.findAll();
    }

    @Override
    public University create(University University) {
        return this.universityRepository.save(University);
    }

    @Override
    public University update(University University) {
        if(!this.universityRepository.existsById(University.getUniversityId())){
            throw new CvBusinessException("CV-1002","University Not Found",HttpStatus.NOT_FOUND);
        }
        return this.universityRepository.save(University);
    }

    @Override
    public Boolean delete(Long id) {
        if(!this.universityRepository.existsById(id)){
            throw new CvBusinessException("CV-1002","University Not Found",HttpStatus.NOT_FOUND);
        }
        this.universityRepository.deleteById(id);
        return true;
    }
    
}
