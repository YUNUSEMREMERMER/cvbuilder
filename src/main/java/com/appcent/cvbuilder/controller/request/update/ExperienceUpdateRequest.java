package com.appcent.cvbuilder.controller.request.update;

import java.sql.Date;

import lombok.Data;

@Data
public class ExperienceUpdateRequest {
 
    private Long experienceId;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private String jobDescription;
    private Boolean isStillWorking;

    private Long jobDepartmentId;
    private Long jobPositionId;
}
