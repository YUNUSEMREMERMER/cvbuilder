package com.appcent.cvbuilder.service.education;

import java.util.List;

import com.appcent.cvbuilder.model.education.University;

public interface UniversityService {
    
    University getUniversity(Long id);
    List<University> getUniversities();
    University create(University University);
    University update(University University);
    Boolean delete(Long id);
    
}

