package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
    
    List<Project> findByCvInfo_CvId(Long cvId);
}
