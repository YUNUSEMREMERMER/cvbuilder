package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.ProjectCreateRequest;
import com.appcent.cvbuilder.controller.request.update.ProjectUpdateRequest;
import com.appcent.cvbuilder.model.Project;

public interface ProjectService {
    
    Project getProject(Long id);
    List<Project> getProjects(Long cvId);
    Project create(ProjectCreateRequest projectCreateRequest);
    Project update(ProjectUpdateRequest projectUpdateRequest);
    Boolean delete(Long id);

}
