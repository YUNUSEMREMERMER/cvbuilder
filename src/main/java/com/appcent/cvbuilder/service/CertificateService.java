package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.CertificateCreateRequest;
import com.appcent.cvbuilder.controller.request.update.CertificateUpdateRequest;
import com.appcent.cvbuilder.model.Certificate;

public interface CertificateService {
    
    List<Certificate> getCertificates(Long cvId);
    Certificate create(CertificateCreateRequest certificateCreateRequest);
    Certificate update(CertificateUpdateRequest certificateUpdateRequest);
    Boolean delete(Long id);
    
    Certificate getCertificate(Long id);
}
