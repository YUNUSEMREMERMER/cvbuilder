package com.appcent.cvbuilder.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appcent.cvbuilder.model.City;
import com.appcent.cvbuilder.service.CityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
    
    private final CityService cityService;

    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id) {
        return this.cityService.getCity(id);
    }

    @GetMapping()
    public List<City> getCity() {
        return this.cityService.getCity();
    }

    @PostMapping()
    public City create(@RequestBody City city) {
        return this.cityService.create(city);
    }

    @PatchMapping()
    public City update(@RequestBody City city){
        return this.cityService.update(city);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return this.cityService.delete(id);
    }
}
