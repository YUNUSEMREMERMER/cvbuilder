package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.controller.request.create.ProjectCreateRequest;
import com.appcent.cvbuilder.controller.request.update.ProjectUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Project;
import com.appcent.cvbuilder.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final CVInfoService cvInfoService;

    @Override
    public Project getProject(Long id) {
        if(!projectRepository.existsById(id)){
            throw new CvBusinessException("CV-1032", "Project not found", HttpStatus.NOT_FOUND);
        }
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> getProjects(Long cvId) {
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv not found",HttpStatus.NOT_FOUND);
        }
        return projectRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Project create(ProjectCreateRequest projectCreateRequest) {
        if(!cvInfoService.existByCvId(projectCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv not found",HttpStatus.NOT_FOUND);
        }
        Project project = Project.builder()
                        .cvId(projectCreateRequest.getCvId())
                        .projectTitle(projectCreateRequest.getProjectTitle())
                        .projectDescription(projectCreateRequest.getProjectDescription())
                        .build();

        return projectRepository.save(project);
    }

    @Override
    public Project update(ProjectUpdateRequest projectUpdateRequest) {
        if(!projectRepository.existsById(projectUpdateRequest.getProjectId())){
            throw new CvBusinessException("CV-1032", "Project not found", HttpStatus.NOT_FOUND);
        }
        Project project = projectRepository.findById(projectUpdateRequest.getProjectId()).orElse(null);
        project.setProjectTitle(projectUpdateRequest.getProjectTitle());
        project.setProjectDescription(projectUpdateRequest.getProjectDescription());
        return projectRepository.save(project);
    }

    @Override
    public Boolean delete(Long id) {
        if(!projectRepository.existsById(id)){
            throw new CvBusinessException("CV-1032", "Project not found", HttpStatus.NOT_FOUND);
        }
        projectRepository.deleteById(id);
        return true;
    }

    
}
