package com.appcent.cvbuilder.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.SkillCreateRequest;
import com.appcent.cvbuilder.controller.request.update.SkillUpdateRequest;
import com.appcent.cvbuilder.model.Skill;
import com.appcent.cvbuilder.service.SkillService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    
    private final SkillService skillService;

    @GetMapping("/{id}")
    public Skill getSkill(@PathVariable Long id) {
        return this.skillService.getSkill(id);
    }

    @PostMapping()
    public Skill create(@RequestBody SkillCreateRequest skillCreateRequest) {
        return this.skillService.create(skillCreateRequest);
    }

    @PatchMapping()
    public Skill update(@RequestBody SkillUpdateRequest skillUpdateRequest) {
        return this.skillService.update(skillUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.skillService.delete(id);
    }

}
