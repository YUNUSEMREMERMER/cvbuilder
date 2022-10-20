package com.appcent.cvbuilder.service.language;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.language.LanguageName;
import com.appcent.cvbuilder.repository.language.LanguageNameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageNameImpl implements LanguageNameService{
    
    private final LanguageNameRepository languageNameRepository;
    
    @Override
    public LanguageName getLanguageName(Long id) {
        if(!languageNameRepository.existsById(id)){
            throw new CvBusinessException("CV-1004", "Language Name Not Found", HttpStatus.NOT_FOUND);
        }
        return this.languageNameRepository.findById(id).orElse(null);
    }

    @Override
    public List<LanguageName> getLanguageNames() {
        return this.languageNameRepository.findAll();

    }

    @Override
    public LanguageName create(LanguageName languageName) {
        return this.languageNameRepository.save(languageName);

    }

    @Override
    public LanguageName update(LanguageName languageName) {
        if(!languageNameRepository.existsById(languageName.getLanguageNameId())){
            throw new CvBusinessException("CV-1004", "Language Name Not Found", HttpStatus.NOT_FOUND);
        }
        return this.languageNameRepository.save(languageName);
    }

    @Override
    public Boolean delete(Long id) {
        if(!languageNameRepository.existsById(id)){
            throw new CvBusinessException("CV-1004", "Language Name Not Found", HttpStatus.NOT_FOUND);
        }
        this.languageNameRepository.deleteById(id);
        return true;
    }

}
