package com.appcent.cvbuilder.service.language;

import java.util.List;

import com.appcent.cvbuilder.model.language.LanguageName;

public interface LanguageNameService {
    
    LanguageName getLanguageName(Long id);
    List<LanguageName> getLanguageNames();
    LanguageName create(LanguageName languageName);
    LanguageName update(LanguageName languageName);
    Boolean delete(Long id);
    
}
