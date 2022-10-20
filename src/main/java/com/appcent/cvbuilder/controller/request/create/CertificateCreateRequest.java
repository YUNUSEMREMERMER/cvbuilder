package com.appcent.cvbuilder.controller.request.create;

import java.sql.Date;

import lombok.Data;

@Data
public class CertificateCreateRequest {
    
    private String programName;
    private String issuer;
    private Date receiveDate;
    private Long cvId;

}
