package com.appcent.cvbuilder.controller.request.create;

import lombok.Data;

@Data
public class LanguageCreateRequest {
    
    private Long languageNameId;
    private Long languageLevelId;
    private Long cvId;

}
