package com.appcent.cvbuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Long>{
    List<Language> findByCvInfo_CvId(Long id);
}
