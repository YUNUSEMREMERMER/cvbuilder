package com.appcent.cvbuilder.controller.api.education;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.model.education.EducationLevel;
import com.appcent.cvbuilder.service.education.EducationLevelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/educations/level")
@RequiredArgsConstructor
public class EducationLevelController {
    
    private final EducationLevelService educationsLevelService;
    
    @GetMapping("/{id}")
    public EducationLevel getCVInformation(@PathVariable Long id){
        return this.educationsLevelService.getEducationLevel(id);
    }

    @GetMapping()
    public List<EducationLevel> getCVInformations(){
        return this.educationsLevelService.getEducationLevels();
    }

    @PostMapping()
    public EducationLevel create(@RequestBody EducationLevel educationLevel) {
        return this.educationsLevelService.create(educationLevel);
    }

    @PatchMapping()
    public EducationLevel update(@RequestBody EducationLevel educationLevel) {
        return this.educationsLevelService.update(educationLevel);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return this.educationsLevelService.delete(id);
    }
}
