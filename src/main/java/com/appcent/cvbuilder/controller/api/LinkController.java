package com.appcent.cvbuilder.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.LinkCreateRequest;
import com.appcent.cvbuilder.controller.request.update.LinkUpdateRequest;
import com.appcent.cvbuilder.model.Link;
import com.appcent.cvbuilder.service.LinkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/links")
@RequiredArgsConstructor
public class LinkController {
    
    private final LinkService linkService;

    @GetMapping("/{id}")
    public Link getLink(@PathVariable Long id) {
        return this.linkService.getLink(id);
    }

    @PostMapping()
    public Link create(@RequestBody LinkCreateRequest linkCreateRequest) {
        return this.linkService.create(linkCreateRequest);
    }

    @PatchMapping()
    public Link update(@RequestBody LinkUpdateRequest linkUpdateRequest) {
        return this.linkService.update(linkUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.linkService.delete(id);
    }

}
