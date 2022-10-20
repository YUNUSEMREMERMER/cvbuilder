package com.appcent.cvbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appcent.cvbuilder.model.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long>{
    
}
