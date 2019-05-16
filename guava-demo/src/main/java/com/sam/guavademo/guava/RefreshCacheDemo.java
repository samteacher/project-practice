package com.sam.guavademo.guava;

import com.google.common.cache.*;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * @author yuqiufu
 * LoadingCache定时更新缓存
 */
public class RefreshCacheDemo {

    private static ScheduledExecutorService scheduledExecutorService = newScheduledThreadPool(1);

    /**
     * 移除监听器
     * 通过CacheBuilder.removalListener(RemovalListener)，你可以声明一个监听器，以便缓存项被移除时做一些额外操作。
     * 缓存项被移除时，RemovalListener会获取移除通知[RemovalNotification]，其中包含移除原因[RemovalCause]、键和值。
     */
    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(10)
            .removalListener(new RemovalListener<String, String>() {
                @Override
                public void onRemoval(RemovalNotification notification) {
                    System.out.println("移除：" + notification.getKey());
                }
            })
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    System.out.println("load key:" + key);
                    String value = key + "_" + "end";
                    return value;
                }
            });


    /**
     * 执行定时刷新
     */
    private static class RefreshJob implements Runnable {
        @Override
        public void run() {
            System.out.println("begin refresh------------");

            /**
             * asMap() 包含了所有现在导入缓存中的键值对
             * cache.asMap().keySet() 包含了所有导入的key
             *
             * cache.asMap()包含当前所有加载到缓存的项。因此相应地，cache.asMap().keySet()包含当前所有已加载键;
             * asMap().get(key)实质上等同于 cache.getIfPresent(key),而且不会引起缓存项的加载。这和 Map 的语义约定一致。
             *
             */
            Set<String> keys = cache.asMap().keySet();
            for (String key : keys) {
                cache.refresh(key);
            }
            System.out.println("end refresh------------");
        }
    }

    /**
     * 使用轮询方式更新缓存
     * 主要解决问题：
     * CacheBuilder.refreshAfterWrite(long, TimeUnit)：可以为缓存增加自动定时刷新功能。
     * 和expireAfterWrite相反，refreshAfterWrite通过定时刷新可以让缓存项保持可用，但请注意：
     * 缓存项只有在被检索时才会真正刷新，即只有刷新间隔时间到了你再去get(key)
     * 才会重新去执行Loading否则就算刷新间隔时间到了也不会执行loading操作。
     * 因此，如果你在缓存上同时声明expireAfterWrite和refreshAfterWrite，
     * 缓存并不会因为刷新盲目地定时重置，如果缓存项没有被检索，那刷新就不会真的发生，
     * 缓存项在过期时间后也变得可以回收。
     * 还有一点比较重要的是refreshAfterWrite和expireAfterWrite两个方法设置以后，
     * 重新get会引起loading操作都是同步串行的。这其实可能会有一个隐患，
     * 当某一个时间点刚好有大量检索过来而且都有刷新或者回收的话，是会产生大量的请求同步调用loading方法，
     * 这些请求占用线程资源的时间明显变长。如正常请求也就20ms，
     * 当刷新以后加上同步请求loading这个功能接口可能响应时间远远大于20ms。
     * 为了预防这种井喷现象，可以不设置CacheBuilder.refreshAfterWrite(long, TimeUnit)，
     * 改用LoadingCache.refresh(K)因为它是异步执行的，不会影响正在读的请求，
     * 同时使用ScheduledExecutorService可以帮助你很好地实现这样的定时调度
     * ，配上cache.asMap().keySet()返回当前所有已加载键，这样所有的key定时刷新就有了。
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(cache.get("lhc"));
        System.out.println(cache.get("jay"));
        System.out.println(cache.get("jasmine"));
        scheduledExecutorService.scheduleAtFixedRate(new RefreshJob(), 0, 1000, TimeUnit.MILLISECONDS);
        Thread.sleep(3000);
        System.out.println("again lhc:--" + cache.get("lhc"));
    }

}
