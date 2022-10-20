package com.appcent.cvbuilder.controller.api.language;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.model.language.LanguageLevel;
import com.appcent.cvbuilder.service.language.LanguageLevelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/languages/level")
@RequiredArgsConstructor
public class LanguageLevelController {
    
    private final LanguageLevelService languageLevelService;

    @GetMapping("/{id}")
    public LanguageLevel getLanguageLevel(@PathVariable Long id) {
        return this.languageLevelService.getLanguageLevel(id);
    }

    @GetMapping()
    public List<LanguageLevel> getLanguageLevels() {
        return this.languageLevelService.getLanguageLevels();
    }

    @PostMapping()
    public LanguageLevel create(@RequestBody LanguageLevel languageLevel) {
        return this.languageLevelService.create(languageLevel);
    }

    @PatchMapping()
    public LanguageLevel update(@RequestBody LanguageLevel languageLevel) {
        return this.languageLevelService.update(languageLevel);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.languageLevelService.delete(id);
    }
    
}
