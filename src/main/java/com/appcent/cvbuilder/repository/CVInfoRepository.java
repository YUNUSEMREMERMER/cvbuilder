package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.CVInfo;

@Repository
public interface CVInfoRepository extends JpaRepository<CVInfo,Long>{

    List<CVInfo> findByUser_UserId(Long id);
}
