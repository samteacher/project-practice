package com.sam.redisdemo.controller;

import com.sam.redisdemo.config.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yuqiufu
 * @since 2019-05-17
 */
@RestController
@RequestMapping("/test")
public class RedisController {

    @Autowired
    RedisService redisService;

    /**
     * 根据key存入字符
     *
     * @param key
     * @param value
     * @date 2019-05-17
     */
    @GetMapping("/setStr")
    private String setString(String key, String value) {
        redisService.set(key, value);
        return "字符类型 - 储存成功";
    }

    /**
     * 根据key获取字符
     *
     * @param key
     * @date 2019-05-17
     */
    @GetMapping("/getStr")
    private String getString(String key) {
        String strName = redisService.get(key);
        return "字符类型 - 获取成功 : " + strName;
    }

    /**
     * 根据key删除字符
     *
     * @param key
     * @date 2019-05-17
     */
    @GetMapping("/delStr")
    private String delString(String key) {
        redisService.del(key);
        return "字符类型 - 删除成功";
    }

    /**
     * 以JSON格式存入
     *
     * @param key
     * @param value
     * @date 2019-05-17
     */
    @GetMapping("/setJsonList")
    private String setJsonList(String key, String value) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("num-1", "1111");
//        jsonObject.put("num-2", "2222");
//        jsonObject.put("num-3", "3333");
        redisService.rightPush(key, value);
        return "成功";
    }

    /**
     * 以List格式存入
     *
     * @param key
     * @param value
     * @date 2019-05-17
     */
    @GetMapping("/setList")
    private String setList(String key, String value) {
//        List<String> stringList = new ArrayList<>();
//        stringList.add("num-1");
//        stringList.add("num-2");
//        stringList.add("num-3");
        redisService.rightPush(key, value);
        return "成功";
    }

    /**
     * 根据当前日期自增主键
     *
     * @date 2019-05-17
     */
    @GetMapping("/getId")
    public String getId() {
        String idStr = redisService.getId();
        return "自增主键：" + idStr;
    }

    /**
     * Hash类型 储存key和value值
     *
     * @param key
     * @param map
     * @date 2019-05-17
     */
    @GetMapping("/hset")
    public String Hset(String key, Map<String, Object> map) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("one", "redis");
//        map.put("two", "java");
//        map.put("three", "golang");
//        map.put("four", "c++");
        redisService.hSet(key, map);
        return "成功";
    }

    /**
     * hash类型 根据key获取元素值
     *
     * @param key
     * @date 2019-05-17
     */
    @GetMapping("/hget")
    public Map<Object, Object> Hget(String key) {
        return redisService.hGet(key);
    }

    /**
     * 根据key删除list左边第一个元素
     *
     * @param key
     * @return
     */
    @GetMapping("lpopList")
    public String lpopList(String key) {
        redisService.lpopList(key);
        return "删除成功";
    }

    @GetMapping("/Rset")
    public Object[] rangeSet(String keyName, String key){
        // ["python","node","java","angular"]
        return redisService.rangeSet(keyName, key);
    }

}
