package com.appcent.cvbuilder.repository.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.skill.SkillLevel;

@Repository
public interface SkillLevelRepository extends JpaRepository<SkillLevel,Long>{
    
}
