package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.controller.request.create.SkillCreateRequest;
import com.appcent.cvbuilder.controller.request.update.SkillUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Skill;
import com.appcent.cvbuilder.repository.SkillRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkillImpl implements SkillService{

    private final SkillRepository skillRepository;
    private final CVInfoService cvInfoService;

    @Override
    public Skill getSkill(Long id) {
        if(!skillRepository.existsById(id)){
            throw new CvBusinessException("CV-1032", "Skill not found", HttpStatus.NOT_FOUND);
        }
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public List<Skill> getSkills(Long cvId) {
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv not found",HttpStatus.NOT_FOUND);
        }
        return skillRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Skill create(SkillCreateRequest skillCreateRequest) {
        if(!cvInfoService.existByCvId(skillCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv not found",HttpStatus.NOT_FOUND);
        }
        Skill skill = Skill.builder()
                        .cvId(skillCreateRequest.getCvId())
                        .skillNameId(skillCreateRequest.getSkillNameId())
                        .skillLevelId(skillCreateRequest.getSkillLevelId())
                        .build();

        return skillRepository.save(skill);
    }

    @Override
    public Skill update(SkillUpdateRequest skillUpdateRequest) {
        if(!skillRepository.existsById(skillUpdateRequest.getSkillId())){
            throw new CvBusinessException("CV-1032", "Skill not found", HttpStatus.NOT_FOUND);
        }
        Skill skill = skillRepository.findById(skillUpdateRequest.getSkillId()).orElse(null);
        skill.setSkillNameId(skillUpdateRequest.getSkillNameId());
        skill.setSkillLevelId(skillUpdateRequest.getSkillLevelId());
        return skillRepository.save(skill);
    }

    @Override
    public Boolean delete(Long id) {
        if(!skillRepository.existsById(id)){
            throw new CvBusinessException("CV-1032", "Skill not found", HttpStatus.NOT_FOUND);
        }
        skillRepository.deleteById(id);
        return true;
    }

    
    
}
