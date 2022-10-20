package com.appcent.cvbuilder.controller.request.create;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EducationCreateRequest {
    
    private Date startDate;
    private Date endDate;
    private Boolean isStillStudent;
    private Long cvId;

    @NotNull
    private Long educationLevelId;
    private Long educationDepartmentId;
    private Long universityId;
    
}
