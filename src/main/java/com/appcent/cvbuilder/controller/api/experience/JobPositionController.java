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

import com.appcent.cvbuilder.model.experience.JobPosition;
import com.appcent.cvbuilder.service.experience.JobPositionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/job/position")
@RequiredArgsConstructor
public class JobPositionController {
    
    private final JobPositionService jobPositionService;

    @GetMapping("/{id}")
    public JobPosition getJobPosition(@PathVariable Long id){
        return jobPositionService.getJobPosition(id);
    }

    @GetMapping()
    public List<JobPosition> getJobPositions() {
        return jobPositionService.getJobPositions();
    }

    @PostMapping()
    public JobPosition create(@RequestBody JobPosition jobPosition) {
        return jobPositionService.create(jobPosition);
    }

    @PatchMapping()
    public JobPosition update(@RequestBody JobPosition jobPosition) {
        return jobPositionService.update(jobPosition);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return jobPositionService.delete(id);
    }

}
