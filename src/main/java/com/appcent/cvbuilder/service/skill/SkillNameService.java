package com.appcent.cvbuilder.service.skill;

import java.util.List;

import com.appcent.cvbuilder.model.skill.SkillName;

public interface SkillNameService {
    
    SkillName getSkillName(Long id);
    List<SkillName> getSkillNames();
    SkillName create(SkillName skillName);
    SkillName update(SkillName skillName);
    Boolean delete(Long id);
    
}
