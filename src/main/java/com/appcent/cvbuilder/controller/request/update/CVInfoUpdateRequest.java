package com.appcent.cvbuilder.controller.request.update;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CVInfoUpdateRequest {
    
    private Long cvId;
    
    @NotBlank
    private String name;

    private Long userId;

    @NotBlank
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phone;

    private String shortResume;

    private String cvLink;

    @NotNull
    private Long cityId;

}
