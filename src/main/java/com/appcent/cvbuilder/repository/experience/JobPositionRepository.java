package com.appcent.cvbuilder.repository.experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.experience.JobPosition;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition,Long>{
    
}
