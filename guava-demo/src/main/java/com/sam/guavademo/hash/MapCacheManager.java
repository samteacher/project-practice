package com.sam.guavademo.hash;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * ConcurrentHashMap融合了Hashtable和HashMap二者的优势。
 * Hashtable是做了线程同步，HashMap未考虑同步。所以HashMap在单线程下效率较高，
 * Hashtable在多线程下同步操作能保证程序的正确性。
 * 但是Hashtable每次执行同步操作都需要锁住整个结构。
 * <p>
 * ConcurrentHashMap 和Guava cache相比，需要自己显示的删除缓存
 */
public class MapCacheManager {

    private final static Log log = LogFactory.getLog(MapCacheManager.class);

    // 更新缓存时记录的时间
    private long updateTime = 0L;

    // 正在更新时的阀门,为false时表示当前没有更新缓存,为true时表示当前正在更新缓存
    private boolean updateFlag = true;

    // 缓存实例对象
    private static MapCacheManager mapCacheObject;

    // 缓存容器
    private static Map<String, String> cacheMap = new ConcurrentHashMap<String, String>();

    private MapCacheManager() {
        // 加载缓存
        this.LoadCache();
        // 缓存更新时间
        updateTime = System.currentTimeMillis();

    }

    /**
     * 拼接一个缓存key
     *
     * @param account
     * @return
     */
    private static String getCacheKey(String account) {
        return Thread.currentThread().getId() + "-" + account;
    }

    /**
     * 初始化缓存
     *
     * @param account
     */
    private static void initCache(String account) {
        // 一般是进行数据库查询，将查询的结果进行缓存
        cacheMap.put(account, "18013093863");
    }

    /**
     * 移除缓存信息
     *
     * @param account
     */
    public static void removeCache(String account) {
        cacheMap.remove(getCacheKey(account));
    }

    /**
     * 获取缓存的对象
     *
     * @param account
     * @return
     */
    public static String getCache(String account) {

        account = getCacheKey(account);
        // 如果缓冲中有该账号，则返回value
        if (cacheMap.containsKey(account)) {
            return cacheMap.get(account);
        }
        // 如果缓存中没有该账号，把该帐号对象缓存到concurrentHashMap中
        initCache(account);
        return cacheMap.get(account);
    }

    /**
     * 采用单例模式获取缓存对象实例
     *
     * @return
     */
    public static MapCacheManager getInstance() {
        if (null == mapCacheObject) {
            synchronized (MapCacheManager.class) {
                if (null == mapCacheObject) {
                    mapCacheObject = new MapCacheManager();
                }
            }
        }
        return mapCacheObject;
    }

    /**
     * 装载缓存
     */
    private void LoadCache() {
        // 正在更新
        this.updateFlag = true;

        /********** 数据处理，将数据放入cacheMap缓存中 **begin ******/
        cacheMap.put("key1", "value1");
        cacheMap.put("key2", "value2");
        cacheMap.put("key3", "value3");
        cacheMap.put("key4", "value4");
        cacheMap.put("key5", "value5");
        /********** 数据处理，将数据放入cacheMap缓存中 ***end *******/
        // 更新已完成
        this.updateFlag = false;

    }

    /**
     * 返回缓存对象
     *
     * @return
     */
    public Map<String, String> getMapCache() {

        long currentTime = System.currentTimeMillis();
        // 前缓存正在更新
        if (this.updateFlag) {
            log.info("cache is Instance .....");
            return null;

        }
        // 如果当前缓存正在更新或者缓存超出时限，需重新加载
        if (this.IsTimeOut(currentTime)) {
            synchronized (this) {
                this.ReLoadCache();
                this.updateTime = currentTime;
            }
        }

        return cacheMap;
    }

    private boolean IsTimeOut(long currentTime) {
        // 超过时限，超时
        return ((currentTime - this.updateTime) > 1000000);
    }

    /**
     * 获取缓存项大小
     *
     * @return
     */
    private int getCacheSize() {
        return cacheMap.size();
    }

    /**
     * 获取更新时间
     *
     * @return
     */
    private long getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 获取更新标志
     *
     * @return
     */
    private boolean getUpdateFlag() {
        return this.updateFlag;
    }

    /**
     * 重新装载
     */
    private void ReLoadCache() {
        cacheMap.clear();
        this.LoadCache();
    }

}
