package com.sam.guavademo.guava;

import com.google.common.cache.*;
import com.sam.guavademo.guava.entity.Student;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 * @since 2019-05-15
 * @desc 使用google guava做内存缓存  缓存信息
 */
public class MemoryCacheDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<Integer, Student> cache
                // CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                = CacheBuilder.newBuilder()
                // 设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                .expireAfterWrite(8, TimeUnit.SECONDS)
                // 设置缓存容器的初始容量为10
                .initialCapacity(10)
                // 设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(100)
                // 设置要统计缓存的命中率
                .recordStats()
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                // build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(
                        new CacheLoader<Integer, Student>() {
                            @Override
                            public Student load(Integer key) throws Exception {
                                System.out.println("load student " + key);
                                Student student = new Student();
                                student.setId(key);
                                student.setName("name " + key);
                                return student;
                            }
                        }
                );

        for (int i = 0; i < 20; i++) {
            // 从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
            Student student = cache.get(1);
            System.out.println(student);
            // 休眠1秒
            TimeUnit.SECONDS.sleep(1);
        }

        /**
         * 20此循环中命中次数是17次，未命中3次，这是因为我们设定缓存的过期时间是写入后的8秒，所以20秒内会失效两次，
         * 另外第一次获取时缓存中也是没有值的，所以才会未命中3次，其他则命中。
         *
         * guava的内存缓存非常强大，可以设置各种选项，而且很轻量，使用方便。另外还提供了下面一些方法，来方便各种需要：
         *
         * 1、ImmutableMap<K, V> getAllPresent(Iterable<?> keys) 一次获得多个键的缓存值
         * 2、putAll方法向缓存中添加一个或者多个缓存项
         * 3、invalidateAll方法从缓存中移除缓存项
         * 4、ConcurrentMap<K, V>快照
         * 5、refresh(Key) 刷新缓存，即重新取缓存数据，更新缓存
         */
        // 打印缓存信息
        System.out.println("cache stats:");
        // 最后打印缓存的命中率等 情况
        System.out.println(cache.stats().toString());
    }

}
