package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.controller.request.create.LanguageCreateRequest;
import com.appcent.cvbuilder.controller.request.update.LanguageUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Language;
import com.appcent.cvbuilder.repository.LanguageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageImpl implements LanguageService{
    
    private final LanguageRepository languageRepository;

    private final CVInfoService cvInfoService;
    
    @Override
    public List<Language> getLanguagesByCvId(Long cvId) {
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        return this.languageRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Language create(LanguageCreateRequest languageCreateRequest) {
        if(!cvInfoService.existByCvId(languageCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        Language newLanguage = Language.builder()
                                    .languageLevelId(languageCreateRequest.getLanguageLevelId())
                                    .languageNameId(languageCreateRequest.getLanguageNameId())
                                    .cvId(languageCreateRequest.getCvId())
                                    .build();
        return this.languageRepository.save(newLanguage);
    }

    @Override
    public Language update(LanguageUpdateRequest languageUpdateRequest) {
        if(!languageRepository.existsById(languageUpdateRequest.getLanguageId())){
            throw new CvBusinessException("CV-1051","Languages not found",HttpStatus.NOT_FOUND);
        }
        Language updateLanguage = languageRepository.findById(languageUpdateRequest.getLanguageId()).orElse(null);
        updateLanguage.setLanguageLevelId(languageUpdateRequest.getLanguageLevelId());
        updateLanguage.setLanguageNameId(languageUpdateRequest.getLanguageNameId());
        return this.languageRepository.save(updateLanguage);
    }

    @Override
    public Boolean delete(Long id) {
        if(!languageRepository.existsById(id)){
            throw new CvBusinessException("CV-1051","Languages not found",HttpStatus.NOT_FOUND);
        }
        this.languageRepository.deleteById(id);
        return true;
    }

    @Override
    public Language getLanguageById(Long id) {
        if(!languageRepository.existsById(id)){
            throw new CvBusinessException("CV-1051","Languages not found",HttpStatus.NOT_FOUND);
        }
        return this.languageRepository.findById(id).orElse(null);
    }
    

}
