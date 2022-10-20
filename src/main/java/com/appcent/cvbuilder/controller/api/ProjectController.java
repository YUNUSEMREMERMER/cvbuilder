package com.appcent.cvbuilder.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.ProjectCreateRequest;
import com.appcent.cvbuilder.controller.request.update.ProjectUpdateRequest;
import com.appcent.cvbuilder.model.Project;
import com.appcent.cvbuilder.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    
    private final ProjectService projectService;

    @GetMapping("/{id}")
    public Project getProject(@PathVariable Long id) {
        return this.projectService.getProject(id);
    }

    @PostMapping()
    public Project create(@RequestBody ProjectCreateRequest projectCreateRequest) {
        return this.projectService.create(projectCreateRequest);
    }

    @PatchMapping()
    public Project update(@RequestBody ProjectUpdateRequest projectUpdateRequest) {
        return this.projectService.update(projectUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.projectService.delete(id);
    }

}
