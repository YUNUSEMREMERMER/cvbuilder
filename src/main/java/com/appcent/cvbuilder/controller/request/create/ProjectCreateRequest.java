package com.appcent.cvbuilder.controller.request.create;

import lombok.Data;

@Data
public class ProjectCreateRequest {
    
    private String projectTitle;
    private String projectDescription;
    private Long cvId;

}
