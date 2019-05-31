package com.sam.testdemo.test20190318;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合
 *
 * @author Administrator
 */
public class MapDemo {

    /**
     * Map获取数据快，存储能力强
     *
     * @param args
     */
    public static void main(String[] args) {

        // 不允许key值重复  value值可以重复
        Map<String, Object> maps = new HashMap<>();
        maps.put("name", "keke");
        maps.put("account", "keke");
        maps.put("age", 30);
        maps.put("address", "湖南长沙");
        maps.put(null, null);
        maps.put(" ", 29.2F);

        // Map集合的遍历 映射遍历
        Set<String> keys = maps.keySet();
        for (Object key : keys) {
            Object value = maps.get(key);
            System.out.println(value);
        }

        System.out.println("Map集合个数：" + maps.size());
        System.out.println("根据Key获取value的值" + maps.get("name"));
        System.out.println("返回此映射所包含的值：" + maps.values());

    }
}