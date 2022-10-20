package com.appcent.cvbuilder.repository.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.language.LanguageName;

@Repository
public interface LanguageNameRepository extends JpaRepository<LanguageName,Long>{
    
}
