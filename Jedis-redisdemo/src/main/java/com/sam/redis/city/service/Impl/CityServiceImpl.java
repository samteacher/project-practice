package com.sam.redis.city.service.Impl;

import com.sam.redis.city.dao.CityMapper;
import com.sam.redis.city.entity.City;
import com.sam.redis.city.service.CityService;
import com.sam.redis.config.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<City> findCityAll() {
        return cityMapper.findCityAll();

    }

    @Override
    public City getCityId(int id) {
        // 从缓存中获取城市信息
        String key = "city_" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            City city = operations.get(key);
            LOGGER.info("CityServiceImpl.getCityId() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }
        // 从 DB 中获取城市信息
        City city = cityMapper.getCityId(id);
        // 插入缓存,设置过期时间
//        operations.set(key, city, 3, TimeUnit.SECONDS);
        // 插入缓存
        operations.set(key, city);
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
        return city;
    }

    @Override
    public Long updateCity(City city) {
        Long ret = cityMapper.updateCity(city);
        // 缓存存在，删除缓存
        String key = "city_" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }
        return ret;
    }

    @Override
    public Long deleteCity(int id) {
        Long ret = cityMapper.deleteCity(id);
        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }
        return ret;
    }

}
