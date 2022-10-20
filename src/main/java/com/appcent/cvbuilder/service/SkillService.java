package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.SkillCreateRequest;
import com.appcent.cvbuilder.controller.request.update.SkillUpdateRequest;
import com.appcent.cvbuilder.model.Skill;

public interface SkillService {
    
    Skill getSkill(Long id);
    List<Skill> getSkills(Long cvId);
    Skill create(SkillCreateRequest skillCreateRequest);
    Skill update(SkillUpdateRequest skillUpdateRequest);
    Boolean delete(Long id);

}
