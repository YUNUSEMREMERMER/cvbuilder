package com.appcent.cvbuilder.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.model.CVInfo;
import com.appcent.cvbuilder.service.CVInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    
    private final CVInfoService cvInfoService;

    @GetMapping("/{userId}/cvs")
    public List<CVInfo> getCVInformations(Long userId){
        return this.cvInfoService.getCVInformations(userId);
    }

}
