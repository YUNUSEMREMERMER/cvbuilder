package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long>{
    
    List<Skill> findByCvInfo_CvId(Long cvId);
}
