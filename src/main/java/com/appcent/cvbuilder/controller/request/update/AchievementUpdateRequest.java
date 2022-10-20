package com.appcent.cvbuilder.controller.request.update;

import lombok.Data;

@Data
public class AchievementUpdateRequest {
    private Long achievementId;
    private String achievementName;
}
