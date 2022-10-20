package com.appcent.cvbuilder.controller.request.update;

import lombok.Data;

@Data
public class LanguageUpdateRequest {
    
    private Long languageId;
    private Long languageNameId;
    private Long languageLevelId;
}
