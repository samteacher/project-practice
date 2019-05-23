package com.sam.redis;

import com.sam.redis.pubsub.jedis.JedisMsgPubSubListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSubTest {

    @Test
    public void subjava() {
        System.out.println("订阅者 ");
        Jedis jr = null;
        try {
            // redis服务地址和端口号
            jr = new Jedis("127.0.0.1", 6379, 0);
            jr.auth("samkeke");

            JedisMsgPubSubListener sp = new JedisMsgPubSubListener();

            // jr客户端配置监听两个channel
            jr.subscribe(sp, "news.share", "news.blog");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jr != null) {
                jr.disconnect();
            }
        }
    }

}
