package com.appcent.cvbuilder.controller.request.create;

import lombok.Data;

@Data
public class AchievementCreateRequest {
    private String achievementName;
    private Long cvId;
}
