package com.appcent.cvbuilder.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appcent.cvbuilder.exception.CvBusinessException;
import com.appcent.cvbuilder.model.City;
import com.appcent.cvbuilder.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityImpl implements CityService{
    
    private final CityRepository cityRepository;

    @Override
    public City getCity(Long id) {
        if(!this.cityRepository.existsById(id)){
            throw new CvBusinessException("CV-1008", "City Not Found", HttpStatus.NOT_FOUND);
        }
        
        return this.cityRepository.findById(id).orElse(null);
    }

    @Override
    public List<City> getCity() {
        return this.cityRepository.findAll();
    }

    @Override
    public City create(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public City update(City city) {
        if(!this.cityRepository.existsById(city.getCityId())){
            throw new CvBusinessException("CV-1008", "City Not Found", HttpStatus.NOT_FOUND);
        }

        return this.cityRepository.save(city);
    }

    @Override
    public Boolean delete(Long id) {
        if(!this.cityRepository.existsById(id)){
            throw new CvBusinessException("CV-1008", "City Not Found", HttpStatus.NOT_FOUND);
        }
        this.cityRepository.deleteById(id);
        return true;
    }
    
    
}
