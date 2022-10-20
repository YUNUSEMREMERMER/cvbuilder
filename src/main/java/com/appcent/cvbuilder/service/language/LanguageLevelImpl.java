package com.appcent.cvbuilder.service.language;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.language.LanguageLevel;
import com.appcent.cvbuilder.repository.language.LanguageLevelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LanguageLevelImpl implements LanguageLevelService{
    
    private final LanguageLevelRepository languageLevelRepository;

    @Override
    public LanguageLevel getLanguageLevel(Long id) {
        if(!languageLevelRepository.existsById(id)){
            throw new CvBusinessException("CV-1005", "Language Level Not Found", HttpStatus.NOT_FOUND);
        }
        return this.languageLevelRepository.findById(id).orElse(null);
    }

    @Override
    public List<LanguageLevel> getLanguageLevels() {
        return this.languageLevelRepository.findAll();
    }

    @Override
    public LanguageLevel create(LanguageLevel languageLevel) {
        return this.languageLevelRepository.save(languageLevel);

    }

    @Override
    public LanguageLevel update(LanguageLevel languageLevel) {
        if(!languageLevelRepository.existsById(languageLevel.getLanguageLevelId())){
            throw new CvBusinessException("CV-1005", "Language Level Not Found", HttpStatus.NOT_FOUND);
        }
        return this.languageLevelRepository.save(languageLevel);

    }

    @Override
    public Boolean delete(Long id) {
        if(!languageLevelRepository.existsById(id)){
            throw new CvBusinessException("CV-1005", "Language Level Not Found", HttpStatus.NOT_FOUND);
        }
        this.languageLevelRepository.deleteById(id);
        return true;
    }
    
}
