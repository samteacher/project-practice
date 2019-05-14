package com.sam.guavademo.hash;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 */
public class CacheTest {

    public static void main(String[] args) {

        MapCacheManager cache = MapCacheManager.getInstance();
        Map<String, String> cacheMap = new ConcurrentHashMap<String, String>();

        cacheMap = cache.getMapCache();
        Set<String> set = cacheMap.keySet();
        Iterator<String> it = set.iterator();

//        System.out.println(cacheMap.get("key2"));

        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + "=" + cacheMap.get(key));
        }


    }

}
