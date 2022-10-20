package com.appcent.cvbuilder.service.skill;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.skill.SkillLevel;
import com.appcent.cvbuilder.repository.skill.SkillLevelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkillLevelImpl implements SkillLevelService{
    
    private final SkillLevelRepository skillLevelRepository;
    
    @Override
    public SkillLevel getSkillLevel(Long id) {
        if(!skillLevelRepository.existsById(id)){
            throw new CvBusinessException("CV-1007", "Skill Level Not Found", HttpStatus.NOT_FOUND);
        }
        return this.skillLevelRepository.findById(id).orElse(null);
    }

    @Override
    public List<SkillLevel> getSkillLevels() {
        return this.skillLevelRepository.findAll();
    }

    @Override
    public SkillLevel create(SkillLevel skillLevel) {
        return this.skillLevelRepository.save(skillLevel);
    }

    @Override
    public SkillLevel update(SkillLevel skillLevel) {
        if(!skillLevelRepository.existsById(skillLevel.getSkillLevelId())){
            throw new CvBusinessException("CV-1007","Skill Level Not Found",HttpStatus.NOT_FOUND);
        }
        return this.skillLevelRepository.save(skillLevel);

    }

    @Override
    public Boolean delete(Long id) {
        if(!skillLevelRepository.existsById(id)){
            throw new CvBusinessException("CV-1007","Skill Level Not Found",HttpStatus.NOT_FOUND);
        }
        this.skillLevelRepository.deleteById(id);
        return true;
    }
    
}
