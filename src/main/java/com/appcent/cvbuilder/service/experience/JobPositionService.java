package com.appcent.cvbuilder.service.experience;

import java.util.List;

import com.appcent.cvbuilder.model.experience.JobPosition;

public interface JobPositionService {
    
    JobPosition getJobPosition(Long id);
    List<JobPosition> getJobPositions();
    JobPosition create(JobPosition JobPosition);
    JobPosition update(JobPosition JobPosition);
    Boolean delete(Long id);

}
