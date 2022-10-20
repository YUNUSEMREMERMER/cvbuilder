package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.controller.request.create.LinkCreateRequest;
import com.appcent.cvbuilder.controller.request.update.LinkUpdateRequest;
import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.Link;
import com.appcent.cvbuilder.repository.LinkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LinkImpl implements LinkService{
    
    private final LinkRepository linkRepository;
    private final CVInfoService cvInfoService;

    @Override
    public Link getLink(Long id) {
        if(!linkRepository.existsById(id)){
            throw new CvBusinessException("CV-1032", "Links not found", HttpStatus.NOT_FOUND);
        }
        return linkRepository.findById(id).orElse(null);
    }

    @Override
    public List<Link> getLinks(Long cvId) {
        if(!cvInfoService.existByCvId(cvId)){
            throw new CvBusinessException("CV-1003","Cv not found",HttpStatus.NOT_FOUND);
        }
        return linkRepository.findByCvInfo_CvId(cvId);
    }

    @Override
    public Link create(LinkCreateRequest linkCreateRequest) {
        if(!cvInfoService.existByCvId(linkCreateRequest.getCvId())){
            throw new CvBusinessException("CV-1003","Cv not found",HttpStatus.NOT_FOUND);
        }
        Link link = Link.builder()
                        .cvId(linkCreateRequest.getCvId())
                        .linkName(linkCreateRequest.getLinkName())
                        .build();

        return linkRepository.save(link);
    }

    @Override
    public Link update(LinkUpdateRequest linkUpdateRequest) {
        if(!linkRepository.existsById(linkUpdateRequest.getLinkId())){
            throw new CvBusinessException("CV-1032", "Link not found", HttpStatus.NOT_FOUND);
        }
        Link link = linkRepository.findById(linkUpdateRequest.getLinkId()).orElse(null);
        link.setLinkName(linkUpdateRequest.getLinkName());
        return linkRepository.save(link);
    }

    @Override
    public Boolean delete(Long id) {
        if(!linkRepository.existsById(id)){
            throw new CvBusinessException("CV-1032", "Link not found", HttpStatus.NOT_FOUND);
        }
        linkRepository.deleteById(id);
        return true;
    }

    
    

}
