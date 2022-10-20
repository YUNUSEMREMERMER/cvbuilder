package com.appcent.cvbuilder.controller.api;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.appcent.cvbuilder.controller.request.create.CVInfoCreateRequest;
import com.appcent.cvbuilder.controller.request.update.CVInfoUpdateRequest;
import com.appcent.cvbuilder.controller.response.ImageUploadResponse;
import com.appcent.cvbuilder.model.*;
import com.appcent.cvbuilder.service.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cv")
@RequiredArgsConstructor
public class CVInfoController {

    private final CVInfoService cvInfoService;
    private final SkillService skillService;
    private final LinkService linkService;
    private final ProjectService projectService;
    private final LanguageService languageService;
    private final HobbyService hobbyService;
    private final ExperienceService experienceService;
    private final EducationService educationService;
    private final CertificateService certificateService;
    private final AchievementService achievementService;

    @GetMapping("/{id}")
    public CVInfo getCVInformation(@PathVariable Long id){
        return this.cvInfoService.getCVInformation(id);
    }

    @GetMapping()
    public List<CVInfo> getCVInformations(){
        return this.cvInfoService.getCVInformations();
    }

    @PostMapping()
    public CVInfo create(@Valid @ModelAttribute CVInfoCreateRequest cvInfoCreateRequest) throws IOException {
        return this.cvInfoService.create(cvInfoCreateRequest);
    }

    @PatchMapping()
    public CVInfo update(@Valid @RequestBody CVInfoUpdateRequest cvInfoUpdateRequest) {
        return this.cvInfoService.update(cvInfoUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
        return this.cvInfoService.delete(id);
    }

    @PostMapping("/{cvId}/image")
    public ImageUploadResponse uploadImage(@PathVariable Long cvId,MultipartFile image) throws IOException{
        return cvInfoService.updateImage(cvId,image);
    }

    @GetMapping("/{cvId}/skills")
    public List<Skill> getSkills(@PathVariable Long cvId){
        return this.skillService.getSkills(cvId);
    }

    @GetMapping("/{cvId}/projects")
    public List<Project> getProjects(@PathVariable Long cvId){
        return this.projectService.getProjects(cvId);
    }

    @GetMapping("/{cvId}/links")
    public List<Link> getLinks(@PathVariable Long cvId){
        return this.linkService.getLinks(cvId);
    }

    @GetMapping("/{cvId}/languages")
    public List<Language> getLanguages(@PathVariable Long cvId){
        return this.languageService.getLanguagesByCvId(cvId);
    }

    @GetMapping("/{cvId}/hobbies")
    public List<Hobby> getHobbies(@PathVariable Long cvId){
        return this.hobbyService.getHobbyByCvId(cvId);
    }

    @GetMapping("/{cvId}/experiences")
    public List<Experience> getExperiences(@PathVariable Long cvId) {
        return this.experienceService.getExperiences(cvId);
    }

    @GetMapping("/{cvId}/educations")
    public List<Education> getEducationByCvId(@PathVariable Long cvId){
        return this.educationService.getEducationByCvId(cvId);
    }

    @GetMapping("/{cvId}/certificates")
    public List<Certificate> getCertificates(@PathVariable Long cvId) {
        return this.certificateService.getCertificates(cvId);
    }

    @GetMapping("/{cvId}/achievements")
    public List<Achievement> getAchievements(@PathVariable Long cvId){
        return this.achievementService.getAchievements(cvId);
    }
}
