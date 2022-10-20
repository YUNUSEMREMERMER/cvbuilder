package com.appcent.cvbuilder.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.controller.request.create.HobbyCreateRequest;
import com.appcent.cvbuilder.controller.request.update.HobbyUpdateRequest;
import com.appcent.cvbuilder.model.Hobby;
import com.appcent.cvbuilder.service.HobbyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/hobbies")
@RequiredArgsConstructor
public class HobbyController {
    
    private final HobbyService hobbyService;

    @GetMapping("/{id}")
    public Hobby getHobbyById(@PathVariable Long id) {
        return this.hobbyService.getHobbyById(id);
    }

    @PostMapping()
    public Hobby create(@RequestBody HobbyCreateRequest hobbyCreateRequest) {
        return this.hobbyService.create(hobbyCreateRequest);
    }

    @PatchMapping()
    public Hobby update(@RequestBody HobbyUpdateRequest hobbyUpdateRequest) {
        return this.hobbyService.update(hobbyUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.hobbyService.delete(id);
    }
    
}
