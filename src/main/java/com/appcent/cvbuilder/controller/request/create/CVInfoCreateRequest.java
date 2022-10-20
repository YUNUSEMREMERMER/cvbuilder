package com.appcent.cvbuilder.controller.request.create;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CVInfoCreateRequest {
    
    @NotBlank
    private String name;

    private Long userId;

    @NotBlank
    private String surname;

    @NotBlank
    @Email
    private String email;

    private MultipartFile picture;

    @NotBlank
    private String phone;

    private String shortResume;

    private String cvLink;

    @NotNull
    private Long cityId;

}
