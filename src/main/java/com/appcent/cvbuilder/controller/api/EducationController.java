package com.appcent.cvbuilder.controller.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.EducationCreateRequest;
import com.appcent.cvbuilder.controller.request.update.EducationUpdateRequest;
import com.appcent.cvbuilder.model.Education;
import com.appcent.cvbuilder.service.EducationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/educations")
@RequiredArgsConstructor
public class EducationController {
    
    private final EducationService educationService;

    @GetMapping("/{id}")
    public Education getEducation(@PathVariable Long id){
        return this.educationService.getEducation(id);
    }

    @PostMapping()
    public Education create(@Valid @RequestBody EducationCreateRequest educationCreateRequest){
        return this.educationService.create(educationCreateRequest);
    }

    @PatchMapping()
    public Education update(@Valid @RequestBody EducationUpdateRequest educationUpdateRequest){
        return this.educationService.update(educationUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return this.educationService.delete(id);
    }

   

}
