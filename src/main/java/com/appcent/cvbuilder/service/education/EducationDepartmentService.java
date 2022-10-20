package com.appcent.cvbuilder.service.education;

import java.util.List;

import com.appcent.cvbuilder.model.education.EducationDepartment;

public interface EducationDepartmentService {
    
    EducationDepartment getEducationDepartment(Long id);
    List<EducationDepartment> getEducationDepartments();
    EducationDepartment create(EducationDepartment educationDepartment);
    EducationDepartment update(EducationDepartment educationDepartment);
    Boolean delete(Long id);

}
