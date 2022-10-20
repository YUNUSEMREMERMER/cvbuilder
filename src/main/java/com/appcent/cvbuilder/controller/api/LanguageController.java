package com.appcent.cvbuilder.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.LanguageCreateRequest;
import com.appcent.cvbuilder.controller.request.update.LanguageUpdateRequest;
import com.appcent.cvbuilder.model.Language;
import com.appcent.cvbuilder.service.LanguageService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/languages")
@RequiredArgsConstructor
public class LanguageController {
    
    private final LanguageService languageService;

    @GetMapping("/{id}")
    public Language getLanguageById(@PathVariable Long id) {
        return this.languageService.getLanguageById(id);
    }

    @PostMapping()
    public Language create(@RequestBody LanguageCreateRequest languageCreateRequest) {
        return this.languageService.create(languageCreateRequest);
    }

    @PatchMapping()
    public Language update(@RequestBody LanguageUpdateRequest languageUpdateRequest) {
        return this.languageService.update(languageUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.languageService.delete(id);
    }
    
}
