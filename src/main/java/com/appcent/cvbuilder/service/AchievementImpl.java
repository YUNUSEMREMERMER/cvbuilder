package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.controller.request.create.AchievementCreateRequest;
import com.appcent.cvbuilder.controller.request.update.AchievementUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Achievement;
import com.appcent.cvbuilder.repository.AchievementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AchievementImpl implements AchievementService{
    
    private final AchievementRepository achievementRepository;
    private final CVInfoService cvInfoService;

    @Override
    public List<Achievement> getAchievements(Long cvId) {
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        return this.achievementRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Achievement create(AchievementCreateRequest achievementCreateRequest) {
        if(!cvInfoService.existByCvId(achievementCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }

        Achievement newAchievement = Achievement
                                            .builder()
                                            .achievementName(achievementCreateRequest.getAchievementName())
                                            .cvId(achievementCreateRequest.getCvId())
                                            .build();

        return this.achievementRepository.save(newAchievement);
    }

    @Override
    public Achievement update(AchievementUpdateRequest achievementUpdateRequest) {
        if(!achievementRepository.existsById(achievementUpdateRequest.getAchievementId())){
            throw new CvBusinessException("CV-1032", "Achievement not found", HttpStatus.NOT_FOUND);
        }
        Achievement updateAchievement = achievementRepository.findById(achievementUpdateRequest.getAchievementId()).orElse(null);
        updateAchievement.setAchievementName(achievementUpdateRequest.getAchievementName());

        return this.achievementRepository.save(updateAchievement);
    }

    @Override
    public Boolean delete(Long id) {
        if(!achievementRepository.existsById(id)){
            throw new CvBusinessException("CV-1032", "Achievement not found", HttpStatus.NOT_FOUND);
        }
        this.achievementRepository.deleteById(id);
        return true;
    }

    @Override
    public Achievement getAchievement(Long id) {
        if(!achievementRepository.existsById(id)){
            throw new CvBusinessException("CV-1032", "Achievement not found", HttpStatus.NOT_FOUND);
        }
        return this.achievementRepository.findById(id).orElse(null);
    }

}
