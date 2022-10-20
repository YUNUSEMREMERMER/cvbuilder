package com.appcent.cvbuilder.service;

import com.appcent.cvbuilder.model.User;

public interface UserService {
    
    Boolean isUserExistFromUid(String uid);
    User create(String uid);
    Boolean delete(Long id);

}
