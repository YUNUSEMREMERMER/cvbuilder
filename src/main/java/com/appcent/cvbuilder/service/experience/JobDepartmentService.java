package com.appcent.cvbuilder.service.experience;

import java.util.List;

import com.appcent.cvbuilder.model.experience.JobDepartment;

public interface JobDepartmentService {
    
    JobDepartment getJobDepartment(Long id);
    List<JobDepartment> getJobDepartments();
    JobDepartment create(JobDepartment JobDepartment);
    JobDepartment update(JobDepartment JobDepartment);
    Boolean delete(Long id);
    
}
