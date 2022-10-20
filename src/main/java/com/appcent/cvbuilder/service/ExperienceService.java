package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.ExperienceCreateRequest;
import com.appcent.cvbuilder.controller.request.update.ExperienceUpdateRequest;
import com.appcent.cvbuilder.model.Experience;

public interface ExperienceService {
    
    List<Experience> getExperiences(Long cvId);
    Experience create(ExperienceCreateRequest experienceCreateRequest);
    Experience update(ExperienceUpdateRequest experienceUpdateRequest);
    Boolean delete(Long id);

    Experience getExperience(Long id);
}
