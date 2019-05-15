package com.sam.guavademo.guava;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 * <p>
 * Guava cache可以在CacheLoader的load方法中加以控制，对同一个Key只能让一个请求去源中读取数据，而其它请求阻塞等待结果
 * <p>
 * 创建Guava cache的两种创建方式
 * 1.CacheLoader  在构建cache对象的时候定义一个CacheLoader来获取数据，在缓存不存在的时候能够自动加载数据到缓存中
 * 2.Callable callback  这个方法返回缓存中相应的值，如果末获取到缓存值则调用Callable方法。这个方法简便实现了“如果有缓存则返回，否则读取、缓存、然后返回”的模式
 *
 * cleanUp是清空过期的缓存
 * cache.invalidateAll()才是清空所有缓存
 */
public class LoadingCacheDemo {

    /**
     * Guava Cache
     *   guava cache是一个本地缓存
     * <p>
     * 优点
     * 1、线程安全的缓存，与ConcurrentMap相似，Guava增加了更多的元素失效策略，ConcurrentMap只能显示的移除元素
     * 2、提供了三种基本的缓存回收方式：基于容量回收、定时回收和基于引用回收。定时回收有两种：按照写入时间，最早写入的最先回收；按照访问时间，最早访问的最早回收
     * 3、监控缓存加载/命中情况
     * 4、集成了多部操作，调用get方式，可以在未命中缓存的时候，从其他地方获取数据源（DB，redis），并加载到缓存中
     */

    /**
     * Guava cache和Ehcache一样也是本地缓存，虽然都是本地缓存，但是在细分领域中也还是有不同的应用场景
     * Guava是google提供的一套Java工具包，而Guava cache作为Guava的cache部分提供了一套非常完善的本地缓存机制
     * 在Guava之前，JDK的Concurrent-HashMap因为能友好的支持并发而被经常用途本地缓存，但它毕竟还是个Map，不具备缓存的一些特性，比如缓存过期、缓存数据的加载/刷新等
     */

    public static void main(String[] args) {

        // 缓存接口LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<String, String> cache
                //CacheBuilder的构造函数是私有的,只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                = CacheBuilder.newBuilder()
                // 设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                //设置写缓存后8秒钟过期
                .expireAfterWrite(8, TimeUnit.SECONDS)
                //设置缓存容器的初始容量为10
                .initialCapacity(10)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(100)
                //设置要统计缓存的命中率
                .recordStats()
                // 缓存1秒后过期
                .expireAfterAccess(1, TimeUnit.SECONDS)
                //设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        // 用getCause()方法把被包装的原始异常提取出来
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                // build方法中可以指定CacheLoader,在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return key;
                    }
                });

        cache.put("j", "java");
        cache.put("c", "cpp");
        cache.put("s", "scala");
        cache.put("g", "go");

        try {
            System.out.println("缓存的个数：" + cache.size());
            System.out.println(cache.get("j"));
            System.out.println(cache.getIfPresent("g"));
            TimeUnit.SECONDS.sleep(2);
            System.out.println(cache.get("s"));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
