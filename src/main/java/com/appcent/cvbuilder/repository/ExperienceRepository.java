package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Long>{
    
    List<Experience> findByCvInfo_CvId(Long cvId);

}
