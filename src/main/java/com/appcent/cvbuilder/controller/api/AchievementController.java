package com.appcent.cvbuilder.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.AchievementCreateRequest;
import com.appcent.cvbuilder.controller.request.update.AchievementUpdateRequest;
import com.appcent.cvbuilder.model.Achievement;
import com.appcent.cvbuilder.service.AchievementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/achievements")
@RequiredArgsConstructor
public class AchievementController {
    
    private final AchievementService achievementService;

    @GetMapping("/{id}")
    public Achievement getAchievement(@PathVariable Long id) {
        return this.achievementService.getAchievement(id);
    }

    @PostMapping()
    public Achievement create(@RequestBody AchievementCreateRequest achievementCreateRequest) {
        return this.achievementService.create(achievementCreateRequest);
    }

    @PatchMapping()
    public Achievement update(@RequestBody AchievementUpdateRequest achievementUpdateRequest) {
        return this.achievementService.update(achievementUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.achievementService.delete(id);
    }

}

