package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.controller.request.create.LinkCreateRequest;
import com.appcent.cvbuilder.controller.request.update.LinkUpdateRequest;
import com.appcent.cvbuilder.model.Link;

public interface LinkService {
    
    Link getLink(Long id);
    List<Link> getLinks(Long cvId);
    Link create(LinkCreateRequest linkCreateRequest);
    Link update(LinkUpdateRequest linkUpdateRequest);
    Boolean delete(Long id);
    
}
