package com.sam.redis.city.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuqiufu
 */
@Data
public class City implements Serializable {

    private int id;

    private int provinceId;

    private String cityName;

    private String description;

}
