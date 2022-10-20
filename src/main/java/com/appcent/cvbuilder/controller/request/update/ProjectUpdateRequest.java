package com.appcent.cvbuilder.controller.request.update;

import lombok.Data;

@Data
public class ProjectUpdateRequest {
    
    private Long projectId;
    private String projectTitle;
    private String projectDescription;

}
