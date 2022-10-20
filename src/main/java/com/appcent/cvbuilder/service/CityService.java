package com.appcent.cvbuilder.service;

import java.util.List;

import com.appcent.cvbuilder.model.City;

public interface CityService {
    
    City getCity(Long id);
    List<City> getCity();
    City create(City city);
    City update(City city);
    Boolean delete(Long id);

}
