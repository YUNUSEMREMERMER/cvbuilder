package com.appcent.cvbuilder.controller.request.update;

import java.sql.Date;

import lombok.Data;

@Data
public class CertificateUpdateRequest {
    
    private Long certificateId;
    private String programName;
    private String issuer;
    private Date receiveDate;

}
