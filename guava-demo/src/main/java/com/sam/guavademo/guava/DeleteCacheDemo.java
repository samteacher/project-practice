package com.sam.guavademo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 */
public class DeleteCacheDemo {

    /**
     * Guava数据删除的三种方式
     * 1.被动删除
     *  1).基于数据大小删除   CacheBuilder.maximumSize(size) size指的是记录数，不是容量，并不是超过缓存容量才会删除，而是接近的时候
     *  2).基于过期时间删除
     *      expireAfterAccess(long, TimeUnit) 某个Key最后一次访问后，再隔多长时间后删除
     *      expireAfterWrite(long, TimeUnit) 某个Key被创建后，再隔多长时间后删除
     *  3).基于引用删除   基于Java的垃圾回收机制，判断缓存的数据引用的关系，如果没有被引用，则Guava cache会将该数据删除
     * <p>
     * 2.主动删除
     *  1).单独删除     Cache.invalidate(key) 将某个Key的缓存直接置为无效
     *  2).批量删除     Cache.invalidateAll(keys) 将一批Key的缓存直接置为无效
     *  3).删除所有数据  Cache.invalidateAll() 删除所有缓存数据
     */

    public static void main(String[] args) {

        /**
         * 1.CacheLoader：抽象类。用于从数据源加载数据，定义load、reload、loadAll等操作
         * 2.CacheBuilder：类，缓存构建器。构建缓存的入口，指定缓存配置参数并初始化本地缓存
         * 3.CacheBuilder在build方法中，会把前面设置的参数，全部传递给LocalCache，它自己实际不参与任何计算。这种初始化参数的方法值得借鉴，代码简洁易读
         * 4.LoadingCache：接口，继承自Cache。定义get、getUnchecked、getAll等操作，这些操作都会从数据源load数据
         */

        // 创建缓存
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(8).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return key;
            }

            public String reload(){
                return null;
            }

        });

        cache.put("j","java");
        cache.put("ja","javascript");
        cache.put("r","react");
        cache.put("v","vue");
        cache.put("n","node");
        cache.put("s","spring");

        try {
            System.out.println(cache.get("j"));
            System.out.println(cache.get("ja"));
            System.out.println(cache.get("r"));
            System.out.println(cache.get("v"));
            System.out.println(cache.get("n"));
            System.out.println(cache.get("s"));

            System.out.println("没有删除缓存之前：" + cache.get("j"));

            // 删除指定缓存
//            cache.invalidate("j");

//            ArrayList<Object> keysList = new ArrayList<>();
//            keysList.add("ja");
//            keysList.add("v");
//            keysList.add("n");
//            // 批量删除缓存
//            cache.invalidateAll(keysList);
//            System.out.println("删除缓存之后：" + cache.getIfPresent("ja"));
//            System.out.println("删除缓存之后：" + cache.getIfPresent("v"));
//            System.out.println("删除缓存之后：" + cache.getIfPresent("n"));

            // 删除所有缓存
            cache.invalidateAll();

            TimeUnit.SECONDS.sleep(1);
            // 获取缓存中key对应的value，如果缓存没命中，返回null
            System.out.println("删除缓存之后：" + cache.getIfPresent("j"));

            System.out.println(cache.get("j"));
            System.out.println(cache.get("ja"));
            System.out.println(cache.get("r"));
            System.out.println(cache.get("v"));
            System.out.println(cache.get("n"));
            System.out.println(cache.get("s"));

            /**
             * cleanUp是清空过期的缓存
             * cache.invalidateAll()才是清空所有缓存
             */
            // 清空缓存
//            cache.cleanUp();
//            System.out.println("删除缓存之后：" + cache.getIfPresent("j"));
//            System.out.println("删除缓存之后：" + cache.getIfPresent("ja"));
//            System.out.println("删除缓存之后：" + cache.getIfPresent("r"));
//            System.out.println("删除缓存之后：" + cache.getIfPresent("v"));
//            System.out.println("删除缓存之后：" + cache.getIfPresent("n"));
//            System.out.println("删除缓存之后：" + cache.getIfPresent("s"));

            // stats() 缓存的状态数据   hitCount 返回Cache的lookup方法命中缓存的次数
            System.out.println("status, hitCount:" + cache.stats().hitCount()
                    // missCount()：返回缓存请求的未命中的次数
                    + ", missCount:" + cache.stats().missCount());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
