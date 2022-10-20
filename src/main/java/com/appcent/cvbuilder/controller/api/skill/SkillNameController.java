package com.appcent.cvbuilder.controller.api.skill;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.model.skill.SkillName;
import com.appcent.cvbuilder.service.skill.SkillNameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/skills/name")
@RequiredArgsConstructor
public class SkillNameController {
    
    private final SkillNameService skillNameService;

    @GetMapping("/{id}")
    public SkillName getSkillName(@PathVariable Long id){
        return this.skillNameService.getSkillName(id);
    }

    @GetMapping()
    public List<SkillName> getSkillNames() {
        return this.skillNameService.getSkillNames();
    }

    @PostMapping()
    public SkillName create(@RequestBody SkillName skillName) {
        return this.skillNameService.create(skillName);
    }

    @PatchMapping()
    public SkillName update(@RequestBody SkillName skillName) {
        return this.skillNameService.update(skillName);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.skillNameService.delete(id);
    }

}
