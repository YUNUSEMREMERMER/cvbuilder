package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.Achievement;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement,Long>{
    
    List<Achievement> findByCvInfo_CvId(Long cvId);

}
