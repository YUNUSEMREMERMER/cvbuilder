package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.Hobby;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby,Long>{
    List<Hobby> findByCvInfo_CvId(Long id);   
}
