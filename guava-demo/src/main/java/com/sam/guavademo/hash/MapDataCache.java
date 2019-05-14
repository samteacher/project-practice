package com.sam.guavademo.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class MapDataCache {

    private static Map<String, Object> cacheMap;

    /**
     * 初始化缓冲
     *
     * @return
     */
    public static Map<String, Object> getCacheMap() {
        if (cacheMap == null) {
            cacheMap = new HashMap<String, Object>();
        }
        return cacheMap;
    }

    /**
     * 取缓冲中的值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object getCache(String key, Object defaultValue) {
        Object obj = getCacheMap().get(key);
        return obj == null ? defaultValue : obj;
    }

    /**
     * 添加缓冲
     *
     * @param key
     * @param value
     */
    public static void putCache(String key, Object value) {
        getCacheMap().put(key, value);
    }

    /**
     * 移除缓冲
     *
     * @param key
     */
    public static void removeCache(String key) {
        getCacheMap().remove(key);
    }

}
