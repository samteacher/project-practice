package com.keke.springredis.service.impl;

import com.keke.springredis.model.RedisModel;
import com.keke.springredis.service.IRedisService;

/**
 * @author Administrator
 */
public class RedisServiceImpl extends IRedisService<RedisModel> {

    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return REDIS_KEY;
    }

}
