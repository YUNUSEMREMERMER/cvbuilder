package com.appcent.cvbuilder.controller.api.experience;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.model.experience.JobDepartment;
import com.appcent.cvbuilder.service.experience.JobDepartmentService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/job/department")
@RequiredArgsConstructor
public class JobDepartmentController {
    
    private final JobDepartmentService jobDepartmentService;

    @GetMapping("/{id}")
    public JobDepartment getJobDepartment(@PathVariable Long id) {
        return jobDepartmentService.getJobDepartment(id);
    }

    @GetMapping()
    public List<JobDepartment> getJobDepartments() {
        return jobDepartmentService.getJobDepartments();
    }

    @PostMapping()
    public JobDepartment create(@RequestBody JobDepartment jobDepartment) {
        return this.jobDepartmentService.create(jobDepartment);
    }
    
    @PatchMapping()
    public JobDepartment update(@RequestBody JobDepartment jobDepartment) {
        return this.jobDepartmentService.update(jobDepartment);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return this.jobDepartmentService.delete(id);
    }
    
}
