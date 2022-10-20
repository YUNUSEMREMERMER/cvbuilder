package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.controller.request.create.HobbyCreateRequest;
import com.appcent.cvbuilder.controller.request.update.HobbyUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Hobby;
import com.appcent.cvbuilder.repository.HobbyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HobbyImpl implements HobbyService{
    
    private final HobbyRepository hobbyRepository;

    private final CVInfoService cvInfoService;

    @Override
    public List<Hobby> getHobbyByCvId(Long cvId) {
        
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }
        
        return this.hobbyRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Hobby create(HobbyCreateRequest hobbyCreateRequest) {
        if(!cvInfoService.existByCvId(hobbyCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }

        Hobby newHobby = Hobby.builder()
                            .hobbyName(hobbyCreateRequest.getHobbyName())
                            .cvId(hobbyCreateRequest.getCvId())
                            .build();

        return this.hobbyRepository.save(newHobby);
    }

    @Override
    public Hobby update(HobbyUpdateRequest hobbyUpdateRequest) {
        if(!hobbyRepository.existsById(hobbyUpdateRequest.getHobbyId())){
            throw new CvBusinessException("CV-1049","Hobby not found",HttpStatus.NOT_FOUND);
        }
        Hobby updateHobby = hobbyRepository.findById(hobbyUpdateRequest.getHobbyId()).orElse(null);
        updateHobby.setHobbyName(hobbyUpdateRequest.getHobbyName());
        
        return this.hobbyRepository.save(updateHobby);
    }

    @Override
    public Boolean delete(Long id) {
        if(!hobbyRepository.existsById(id)){
            throw new CvBusinessException("CV-1049","Hobby not found",HttpStatus.NOT_FOUND);
        }
        this.hobbyRepository.deleteById(id);
        return true;
    }

    @Override
    public Hobby getHobbyById(Long id) {
        if(!hobbyRepository.existsById(id)){
            throw new CvBusinessException("CV-1049","Hobby not found",HttpStatus.NOT_FOUND);
        }
        return hobbyRepository.findById(id).orElse(null);
    }
}
