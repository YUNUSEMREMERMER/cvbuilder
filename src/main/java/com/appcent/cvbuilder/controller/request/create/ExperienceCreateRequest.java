package com.appcent.cvbuilder.controller.request.create;

import java.sql.Date;

import lombok.Data;

@Data
public class ExperienceCreateRequest {
    
    private String companyName;
    private Date startDate;
    private Date endDate;
    private String jobDescription;
    private Boolean isStillWorking;

    private Long cvId;
    private Long jobDepartmentId;
    private Long jobPositionId;
}
