package com.appcent.cvbuilder.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.ExperienceCreateRequest;
import com.appcent.cvbuilder.controller.request.update.ExperienceUpdateRequest;
import com.appcent.cvbuilder.model.Experience;
import com.appcent.cvbuilder.service.ExperienceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    
    private final ExperienceService experienceService;

    @GetMapping("/{id}")
    public Experience getExperience(@PathVariable Long id) {
        return this.experienceService.getExperience(id);
    }

    @PostMapping()
    public Experience create(@RequestBody ExperienceCreateRequest experienceCreateRequest) {
        return this.experienceService.create(experienceCreateRequest);
    }

    @PatchMapping()
    public Experience update(@RequestBody ExperienceUpdateRequest experienceUpdateRequest) {
        return this.experienceService.update(experienceUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.experienceService.delete(id);
    }

}
