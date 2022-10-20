package com.appcent.cvbuilder.service.education;

import java.util.List;

import com.appcent.cvbuilder.model.education.EducationLevel;

public interface EducationLevelService {
    
    EducationLevel getEducationLevel(Long id);
    List<EducationLevel> getEducationLevels();
    EducationLevel create(EducationLevel EducationLevel);
    EducationLevel update(EducationLevel EducationLevel);
    Boolean delete(Long id);

}
