package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.AchievementCreateRequest;
import com.appcent.cvbuilder.controller.request.update.AchievementUpdateRequest;
import com.appcent.cvbuilder.model.Achievement;

public interface AchievementService {

    List<Achievement> getAchievements(Long cvId);
    Achievement create(AchievementCreateRequest achievementCreateRequest);
    Achievement update(AchievementUpdateRequest achievementUpdateRequest);
    Boolean delete(Long id);

    Achievement getAchievement(Long id);
}
