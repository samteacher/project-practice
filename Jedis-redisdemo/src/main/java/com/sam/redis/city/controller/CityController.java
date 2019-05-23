package com.sam.redis.city.controller;

import com.sam.redis.city.entity.City;
import com.sam.redis.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuqiufu
 */
@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/findAll")
    public List<City> findCityAll() {
        return cityService.findCityAll();
    }

    @GetMapping("/get")
    public City getCityId(int id) {
        return cityService.getCityId(id);
    }



}
