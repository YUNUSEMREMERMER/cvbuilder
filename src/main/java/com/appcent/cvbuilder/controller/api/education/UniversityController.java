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

import com.appcent.cvbuilder.model.education.University;
import com.appcent.cvbuilder.service.education.UniversityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/educations/university")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping("/{id}")
    public University getCVInformation(@PathVariable Long id){
        return this.universityService.getUniversity(id);
    }

    @GetMapping()
    public List<University> getCVInformations(){
        return this.universityService.getUniversities();
    }

    @PostMapping()
    public University create(@RequestBody University university) {
        return this.universityService.create(university);
    }

    @PatchMapping()
    public University update(@RequestBody University university) {
        return this.universityService.update(university);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return this.universityService.delete(id);
    }
}
