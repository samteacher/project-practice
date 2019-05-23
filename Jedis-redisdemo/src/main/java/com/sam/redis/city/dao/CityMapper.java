package com.sam.redis.city.dao;

import com.sam.redis.city.entity.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface CityMapper {

    List<City> findCityAll();

    City getCityId(int id);

    Long updateCity(City city);

    Long deleteCity(int id);

}
