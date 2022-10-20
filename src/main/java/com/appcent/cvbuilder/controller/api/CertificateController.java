package com.appcent.cvbuilder.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.CertificateCreateRequest;
import com.appcent.cvbuilder.controller.request.update.CertificateUpdateRequest;
import com.appcent.cvbuilder.model.Certificate;
import com.appcent.cvbuilder.service.CertificateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/certificates")
@RequiredArgsConstructor
public class CertificateController {
    
    private final CertificateService certificateService;

    @GetMapping("/{id}")
    public Certificate getCertificate(@PathVariable Long id){
        return this.certificateService.getCertificate(id);
    }

    @PostMapping()
    public Certificate create(@RequestBody CertificateCreateRequest certificateCreateRequest) {
        return this.certificateService.create(certificateCreateRequest);
    }

    @PatchMapping()
    public Certificate update(@RequestBody CertificateUpdateRequest certificateUpdateRequest) {
        return this.certificateService.update(certificateUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.certificateService.delete(id);
    }

}
