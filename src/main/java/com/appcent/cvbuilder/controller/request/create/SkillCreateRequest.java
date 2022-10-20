package com.appcent.cvbuilder.controller.request.create;

import lombok.Data;

@Data
public class SkillCreateRequest {
    
    private Long skillNameId;
    private Long skillLevelId;
    private Long cvId;
}
