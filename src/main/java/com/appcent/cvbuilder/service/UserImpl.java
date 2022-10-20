package com.appcent.cvbuilder.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.User;
import com.appcent.cvbuilder.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService{

    private final UserRepository userRepository;
    
    @Override
    public Boolean isUserExistFromUid(String uid) {
        if(userRepository.findByFirebaseUId(uid) != null){
            return true;
        }
        return false;
    }

    @Override
    public User create(String uid) {
        User newUser = User.builder()
                        .firebaseUId(uid)
                        .build();
        return userRepository.save(newUser);
    }

    @Override
    public Boolean delete(Long id) {
        if(!userRepository.existsById(id)){
            throw new CvBusinessException("CV-1012","User not found", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return true;
    }
    
}
