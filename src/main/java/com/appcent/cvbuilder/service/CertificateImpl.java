package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.appcent.cvbuilder.controller.request.create.CertificateCreateRequest;
import com.appcent.cvbuilder.controller.request.update.CertificateUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Certificate;
import com.appcent.cvbuilder.repository.CertificateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CertificateImpl implements CertificateService{
    
    private final CertificateRepository certificateRepository;
    private final CVInfoService cvInfoService;
    
    @Override
    public List<Certificate> getCertificates(Long cvId) {
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }

        return this.certificateRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Certificate create(CertificateCreateRequest certificateCreateRequest) {
        if(!cvInfoService.existByCvId(certificateCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv Not Found",HttpStatus.NOT_FOUND);
        }

        Certificate newCertificate = Certificate
                                            .builder()
                                            .programName(certificateCreateRequest.getProgramName())
                                            .issuer(certificateCreateRequest.getIssuer())
                                            .receiveDate(certificateCreateRequest.getReceiveDate())
                                            .cvId(certificateCreateRequest.getCvId())
                                            .build();

        return this.certificateRepository.save(newCertificate);
    }

    @Override
    public Certificate update(CertificateUpdateRequest certificateUpdateRequest) {
        if(!certificateRepository.existsById(certificateUpdateRequest.getCertificateId())){
            throw new CvBusinessException("CV-1028", "Certificate not found", HttpStatus.NOT_FOUND);
        }
        Certificate updateCertificate = certificateRepository.findById(certificateUpdateRequest.getCertificateId()).orElse(null);
        updateCertificate.setProgramName(certificateUpdateRequest.getProgramName());
        updateCertificate.setIssuer(certificateUpdateRequest.getIssuer());
        updateCertificate.setReceiveDate(certificateUpdateRequest.getReceiveDate());

        return this.certificateRepository.save(updateCertificate);
    }

    @Override
    public Boolean delete(Long id) {
        if(!certificateRepository.existsById(id)){
            throw new CvBusinessException("CV-1028", "Certificate not found", HttpStatus.NOT_FOUND);
        }
        this.certificateRepository.deleteById(id);
        return true;
    }

    @Override
    public Certificate getCertificate(Long id) {
        if(!certificateRepository.existsById(id)){
            throw new CvBusinessException("CV-1028", "Certificate not found", HttpStatus.NOT_FOUND);
        }
        return this.certificateRepository.findById(id).orElse(null);
    }
}
