package com.appcent.cvbuilder.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.education.EducationDepartment;

@Repository
public interface EducationDepartmentRepository extends JpaRepository<EducationDepartment,Long> {
    
}
