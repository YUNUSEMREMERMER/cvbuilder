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

import com.appcent.cvbuilder.model.education.EducationDepartment;
import com.appcent.cvbuilder.service.education.EducationDepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/educations/department")
@RequiredArgsConstructor
public class EducationDepartmentController {

    private final EducationDepartmentService educationDepartmentService;

    @GetMapping("/{id}")
    public EducationDepartment getCVInformation(@PathVariable Long id){
        return this.educationDepartmentService.getEducationDepartment(id);
    }

    @GetMapping()
    public List<EducationDepartment> getCVInformations(){
        return this.educationDepartmentService.getEducationDepartments();
    }

    @PostMapping()
    public EducationDepartment create(@RequestBody EducationDepartment educationDepartment) {
        return this.educationDepartmentService.create(educationDepartment);
    }

    @PatchMapping()
    public EducationDepartment update(@RequestBody EducationDepartment educationDepartment) {
        return this.educationDepartmentService.update(educationDepartment);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return this.educationDepartmentService.delete(id);
    }
}
