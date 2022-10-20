package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.LanguageCreateRequest;
import com.appcent.cvbuilder.controller.request.update.LanguageUpdateRequest;
import com.appcent.cvbuilder.model.Language;

public interface LanguageService {
    
    List<Language> getLanguagesByCvId(Long cvId);
    Language create(LanguageCreateRequest languageCreateRequest);
    Language update(LanguageUpdateRequest languageUpdateRequest);
    Boolean delete(Long id);

    Language getLanguageById(Long id);
    
}
