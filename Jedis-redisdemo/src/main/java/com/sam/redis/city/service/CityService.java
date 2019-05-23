package com.sam.redis.city.service;

import com.sam.redis.city.entity.City;

import java.util.List;

/**
 * @author yuqiufu
 */
public interface CityService {

    /**
     * 查询全部信息
     *
     * @return
     */
    List<City> findCityAll();

    /**
     * 根据ID查询信息
     *
     * @param id
     * @return
     */
    City getCityId(int id);

    Long updateCity(City city);

    Long deleteCity(int id);

}
