package com.sam.redisdemo.config;

import com.alibaba.fastjson.JSON;
import com.sam.redisdemo.util.Utils;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class RedisService {

    private RedisTemplate redisTemplate;

    public RedisService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private void setRedisIndex(Integer index) {
        boolean flag = null == index || index < 0 || index > 15;
        if (flag) {
            index = 0;
        }

        LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) this.redisTemplate.getConnectionFactory();
        lettuceConnectionFactory.setDatabase(index);
        this.redisTemplate.setConnectionFactory(lettuceConnectionFactory);
    }

    public boolean expire(String key, long expire, TimeUnit timeUnit) {
        boolean flag = false;
        if (expire > 0L) {
            flag = this.redisTemplate.expire(key, expire, timeUnit);
        }

        return flag;
    }

    /**
     * 自增主键
     *
     * @return
     */
    public String getId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String formatDate = sdf.format(date);
        String key = "key" + formatDate;

        Long incr = getIncr(key, Utils.getCurrent2TodayEndMillisTime());

        if (incr == 0) {
            // 从001开始
            incr = getIncr(key, Utils.getCurrent2TodayEndMillisTime());
        }

        // 三位序列号
        DecimalFormat df = new DecimalFormat("000");
        return formatDate + df.format(incr);
    }

    /**
     * 自增主键 设置过期时间
     *
     * @param key
     * @param liveTime
     * @return
     */
    public Long getIncr(String key, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();

        // 初始设置过期时间
        if ((null == increment || increment.longValue() == 0) && liveTime > 0) {
            // 单位毫秒
            entityIdCounter.expire(liveTime, TimeUnit.MILLISECONDS);
        }
        return increment;
    }

    /**
     * @param key key
     * @return
     * @Description: 获取自增长值
     */
    public Long getIncr(String key) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();
        entityIdCounter.expire(0, TimeUnit.SECONDS);
        return increment;
    }

    /**
     * @param key   key
     * @param value 当前值
     * @Description: 初始化自增长值
     */
    public void setIncr(String key, int value) {
        RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        counter.set(value);
        counter.expire(0, TimeUnit.SECONDS);
    }

    public long getExpire(String key, TimeUnit timeUnit) {
        return this.redisTemplate.getExpire(key, timeUnit);
    }

    public boolean hasKey(String key) {
        return this.redisTemplate.hasKey(key);
    }

    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                this.redisTemplate.delete(key[0]);
            } else {
                this.redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }

    }

    private <T> T fromJson(String str, Class<T> tClass) {
        return JSON.toJavaObject(JSON.parseObject(str), tClass);
    }

    private <T> List<T> fromJsonArray(String str, Class<T> tClass) {
        return JSON.parseArray(str, tClass);
    }

    public <T> T get(String key, Class<T> tClass) {
        if (key == null) {
            return null;
        } else {
            Object o = this.redisTemplate.opsForValue().get(key);
            return null != o ? this.fromJson(o.toString(), tClass) : null;
        }
    }

    public String get(String key) {
        if (key == null) {
            return null;
        } else {
            Object o = this.redisTemplate.opsForValue().get(key);
            return null != o ? this.redisTemplate.opsForValue().get(key).toString() : null;
        }
    }

    public void set(String key, Object value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object value, long expire, TimeUnit timeUnit) {
        this.set(key, value);
        if (expire > 0L) {
            this.expire(key, expire, timeUnit);
        }

    }

    public long increment(String key, long delta) {
        return this.redisTemplate.opsForValue().increment(key, delta);
    }

    public Object hGet(String key, String item) {
        return this.redisTemplate.opsForHash().get(key, item);
    }

    public Map<Object, Object> hGet(String key) {
        return this.redisTemplate.opsForHash().entries(key);
    }

    public void hSet(String key, Map<String, Object> map) {
        this.redisTemplate.opsForHash().putAll(key, map);
    }

    public void hSet(String key, Map<String, Object> map, long expire, TimeUnit timeUnit) {
        this.hSet(key, map);
        if (expire > 0L) {
            this.expire(key, expire, timeUnit);
        }

    }

    public void hSet(String key, String item, Object value) {
        this.redisTemplate.opsForHash().put(key, item, value);
    }

    public void hSet(String key, String item, Object value, long expire, TimeUnit timeUnit) {
        this.hSet(key, item, value);
        if (expire > 0L) {
            this.expire(key, expire, timeUnit);
        }

    }

    public long hDel(String key, Object... item) {
        return this.redisTemplate.opsForHash().delete(key, item);
    }

    public boolean hHasKey(String key, String item) {
        return this.redisTemplate.opsForHash().hasKey(key, item);
    }

    public double hIncrement(String key, String item, double by) {
        return this.redisTemplate.opsForHash().increment(key, item, by);
    }

    public Set<Object> sGet(String key) {
        return this.redisTemplate.opsForSet().members(key);
    }

    public boolean sHasKey(String key, Object value) {
        return this.redisTemplate.opsForSet().isMember(key, value);
    }

    public long sSet(String key, Object... values) {
        return this.redisTemplate.opsForSet().add(key, values);
    }

    public long sSetAndTime(String key, long expire, TimeUnit timeUnit, Object... values) {
        long count = this.sSet(key, values, values);
        if (expire > 0L) {
            this.expire(key, expire, timeUnit);
        }

        return count;
    }

    public long sGetSetSize(String key) {
        return this.redisTemplate.opsForSet().size(key);
    }

    public long setRemove(String key, Object... values) {
        return this.redisTemplate.opsForSet().remove(key, values);
    }

    public List<Object> lGet(String key, long start, long end) {
        return this.redisTemplate.opsForList().range(key, start, end);
    }

    public long lGetListSize(String key) {
        return this.redisTemplate.opsForList().size(key);
    }

    public Object lGetIndex(String key, long listIndex) {
        return this.redisTemplate.opsForList().index(key, listIndex);
    }

    public void lSet(String key, Object value) {
        this.redisTemplate.opsForList().rightPush(key, value);
    }

    public void lSet(String key, Object value, long expire, TimeUnit timeUnit) {
        this.lSet(key, value);
        if (expire > 0L) {
            this.expire(key, expire, timeUnit);
        }

    }

    public void lSet(String key, List<Object> value) {
        this.redisTemplate.opsForList().rightPushAll(key, value);
    }

    public void lSet(String key, List<Object> value, long expire, TimeUnit timeUnit) {
        this.lSet(key, value);
        this.redisTemplate.opsForList().rightPushAll(key, value);
        if (expire > 0L) {
            this.expire(key, expire, timeUnit);
        }

    }

    public void lUpdateIndex(String key, long listIndex, Object value) {
        this.redisTemplate.opsForList().set(key, listIndex, value);
    }

    public long lRemove(String key, long count, Object value) {
        return this.redisTemplate.opsForList().remove(key, count, value);
    }

    public Object rightPopTimeout(String key, long timeout, TimeUnit timeUnit) {
        return this.redisTemplate.opsForList().rightPop(key, timeout, timeUnit);
    }

    public Object rightPop(String key) {
        return this.redisTemplate.opsForList().rightPop(key);
    }

    public long rightPush(String key, String value) {
        return this.redisTemplate.opsForList().rightPush(key, value);
    }

    public long rightPushAll(String key, String... value) {
        return this.redisTemplate.opsForList().rightPushAll(key, value);
    }

    public long rightPushAll(String key, List<String> list) {
        return this.redisTemplate.opsForList().rightPushAll(key, list);
    }

}
