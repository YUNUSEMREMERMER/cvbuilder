package com.appcent.cvbuilder.service.skill;

import java.util.List;

import com.appcent.cvbuilder.model.skill.SkillLevel;

public interface SkillLevelService {
    
    SkillLevel getSkillLevel(Long id);
    List<SkillLevel> getSkillLevels();
    SkillLevel create(SkillLevel skillLevel);
    SkillLevel update(SkillLevel skillLevel);
    Boolean delete(Long id);
    
}
