package com.appcent.cvbuilder.controller.request.update;

import java.sql.Date;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EducationUpdateRequest {
    
    private Long educationId;
    private Date startDate;
    private Date endDate;
    private Boolean isStillStudent;

    @NotNull
    private Long educationLevelId;
    private Long educationDepartmentId;
    private Long universityId;
    


}
