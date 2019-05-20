package com.sam.redisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisPubTest {

    @Test
    public void pubjava() {
        System.out.println("发布者 ");
        Jedis jr = null;
        try {
            // redis服务地址和端口号
            jr = new Jedis("127.0.0.1", 6379, 0);
            jr.auth("samkeke");

            // jr客户端配置监听两个channel
            jr.publish( "news.share", "新闻分享");
            jr.publish( "news.blog", "新闻博客");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jr != null) {
                jr.disconnect();
            }
        }
    }

}
