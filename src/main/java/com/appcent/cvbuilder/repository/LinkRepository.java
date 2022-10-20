package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link,Long>{
    
    List<Link> findByCvInfo_CvId(Long cvId);
}
