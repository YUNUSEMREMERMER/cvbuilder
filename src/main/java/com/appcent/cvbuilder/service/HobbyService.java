package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.HobbyCreateRequest;
import com.appcent.cvbuilder.controller.request.update.HobbyUpdateRequest;
import com.appcent.cvbuilder.model.Hobby;

public interface HobbyService {

    List<Hobby> getHobbyByCvId(Long cvId);
    Hobby create(HobbyCreateRequest hobbyCreateRequest);
    Hobby update(HobbyUpdateRequest hobbyUpdateRequest);
    Boolean delete(Long id);
    
    Hobby getHobbyById(Long id);
    
}
