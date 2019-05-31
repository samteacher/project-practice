package com.sam.testdemo.march_sex;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap
 * 相同的对象其hashCode()返回值必须相同，如果键是自定义的类，就特别需要注意这一点
 *
 * @author Administrator
 */
public class HashMapTest {

    public static void main(String[] args) {

//        Random rnd = new Random();
//        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
//
//        for (int i = 0; i < 100; i++) {
//            int num = rnd.nextInt(4);
//            Integer count = countMap.get(num);
//            if (count == null) {
//                countMap.put(num, 1);
//            } else {
//                countMap.put(num, count + 1);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> kv : countMap.entrySet()) {
//            System.out.println(kv.getKey() + "," + kv.getValue());
//        }

        // 典型的泛型  HashMap中的 replace
//        default V replace(K key, V value) {
//            V curValue;
//            if (((curValue = get(key)) != null) || containsKey(key)) {
//                curValue = put(key, value);
//            }
//            return curValue;
//        }


        // HashMap允许key、value为空
        // HashMap允许key值相同,去重
        // HashMap允许value相同
        // HashMap没有顺序，如果要保持添加的顺序，可以使用HashMap的一个子类LinkedHashMap。Map还有一个重要的实现类TreeMap，可以排序
        Map<String, String> strMap = new HashMap<>();
        strMap.put(null, null);
        strMap.put("", "");
        strMap.put("name", "");
        strMap.put("name", "Jery");
        strMap.put("name", "keke");
        strMap.put("account", "keke");
        System.out.println(strMap);


    }
}
