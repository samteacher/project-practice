package com.sam.springbootjedis.test;


import redis.clients.jedis.Jedis;

public class JedisConnectionTest {

    public static void main(String[] args) {
        // 连接本地的 Redis 服务   默认端口
        Jedis jedis = new Jedis("127.0.0.1");

        // 指定密码
        // jedis.auth("redis");

        // 删除元素中的值
        jedis.del("runoob");

        // 往key为runoob的value值追加内容
        //jedis.append("runoob", "html");

        // 获取存储的数据并输出
        System.out.println("runoob : " + jedis.get("runoob"));

        // 关闭jedis
        jedis.close();

    }

}
