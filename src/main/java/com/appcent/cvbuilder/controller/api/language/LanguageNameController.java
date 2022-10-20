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

import com.appcent.cvbuilder.model.language.LanguageName;
import com.appcent.cvbuilder.service.language.LanguageNameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/languages/name")
@RequiredArgsConstructor
public class LanguageNameController {
    
    private final LanguageNameService languageNameService;

    @GetMapping("/{id}")
    public LanguageName getLanguageName(@PathVariable Long id) {
        return this.languageNameService.getLanguageName(id);
    }

    @GetMapping()
    public List<LanguageName> getLanguageNames() {
        return this.languageNameService.getLanguageNames();
    }

    @PostMapping()
    public LanguageName create(@RequestBody LanguageName languageName) {
        return this.languageNameService.create(languageName);
    }

    @PatchMapping()
    public LanguageName update(@RequestBody LanguageName languageName) {
        return this.languageNameService.update(languageName);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.languageNameService.delete(id);
    }
}
