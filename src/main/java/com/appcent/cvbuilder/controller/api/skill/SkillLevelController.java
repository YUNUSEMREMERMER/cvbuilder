package com.appcent.cvbuilder.controller.api.skill;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.model.skill.SkillLevel;
import com.appcent.cvbuilder.service.skill.SkillLevelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/skills/level")
@RequiredArgsConstructor
public class SkillLevelController {
    
    private final SkillLevelService skillLevelService;

    @GetMapping("/{id}")
    public SkillLevel getSkillLevel(@PathVariable Long id){
        return this.skillLevelService.getSkillLevel(id);
    }

    @GetMapping()
    public List<SkillLevel> getSkillLevels() {
        return this.skillLevelService.getSkillLevels();
    }

    @PostMapping()
    public SkillLevel create(@RequestBody SkillLevel skillLevel) {
        return this.skillLevelService.create(skillLevel);
    }

    @PatchMapping()
    public SkillLevel update(@RequestBody SkillLevel skillLevel) {
        return this.skillLevelService.update(skillLevel);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.skillLevelService.delete(id);
    }
}
