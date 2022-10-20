package com.appcent.cvbuilder.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.education.University;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long>{
    
}
