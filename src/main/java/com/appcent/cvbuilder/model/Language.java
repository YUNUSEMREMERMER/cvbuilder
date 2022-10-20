package com.appcent.cvbuilder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.appcent.cvbuilder.model.language.LanguageName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.appcent.cvbuilder.model.language.LanguageLevel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "language")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvInfo","cvId","languageNameId","languageLevelId"})
public class Language {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "languageId")
    private Long languageId;

    @Column(name = "cvId")
    private Long cvId;

    @Column(name = "languageNameId")
    private Long languageNameId;

    @Column(name = "languageLevelId")
    private Long languageLevelId;

    @ManyToOne()
    @JoinColumn(name = "cvId",insertable = false,updatable = false)
    private CVInfo cvInfo;

    @ManyToOne()
    @JoinColumn(name = "languageNameId",insertable = false,updatable = false)
    private LanguageName languageName;

    @ManyToOne()
    @JoinColumn(name = "languageLevelId",insertable = false,updatable = false)
    private LanguageLevel languageLevel;
}
