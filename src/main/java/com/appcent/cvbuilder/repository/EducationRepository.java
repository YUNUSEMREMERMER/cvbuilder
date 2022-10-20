package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long>{
    
    List<Education> findByCvInfo_CvId(Long id);

}
