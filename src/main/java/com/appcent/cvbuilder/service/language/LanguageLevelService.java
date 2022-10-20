package com.appcent.cvbuilder.service.language;

import java.util.List;

import com.appcent.cvbuilder.model.language.LanguageLevel;

public interface LanguageLevelService {
    
    LanguageLevel getLanguageLevel(Long id);
    List<LanguageLevel> getLanguageLevels();
    LanguageLevel create(LanguageLevel languageLevel);
    LanguageLevel update(LanguageLevel languageLevel);
    Boolean delete(Long id);
    
}
