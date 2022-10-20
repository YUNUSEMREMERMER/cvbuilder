package com.appcent.cvbuilder.service.skill;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.skill.SkillName;
import com.appcent.cvbuilder.repository.skill.SkillNameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkillNameImpl implements SkillNameService{
    
    private final SkillNameRepository skillNameRepository;
    
    @Override
    public SkillName getSkillName(Long id) {
        if(!skillNameRepository.existsById(id)){
            throw new CvBusinessException("CV-1006", "Skill Name Not Found", HttpStatus.NOT_FOUND);
        }
        return this.skillNameRepository.findById(id).orElse(null);
    }

    @Override
    public List<SkillName> getSkillNames() {
        return this.skillNameRepository.findAll();
    }

    @Override
    public SkillName create(SkillName skillName) {
        return this.skillNameRepository.save(skillName);
    }

    @Override
    public SkillName update(SkillName skillName) {
        if(!skillNameRepository.existsById(skillName.getSkillNameId())){
            throw new CvBusinessException("CV-1006", "Skill Name Not Found", HttpStatus.NOT_FOUND);
        }
        return this.skillNameRepository.save(skillName);
    }

    @Override
    public Boolean delete(Long id) {
        if(!skillNameRepository.existsById(id)){
            throw new CvBusinessException("CV-1006", "Skill Name Not Found", HttpStatus.NOT_FOUND);
        }
        this.skillNameRepository.deleteById(id);
        return true;
    }
    
}
