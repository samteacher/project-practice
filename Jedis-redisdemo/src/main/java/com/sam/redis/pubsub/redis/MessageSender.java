package com.sam.redis.pubsub.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 开启定时器功能
 *
 * @author yuqiufu
 * @since 2019-05-21
 */
@EnableScheduling
@Component
public class MessageSender {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 间隔2s 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
     */
//    @Scheduled(fixedRate = 3000)
    public void sendMessage() {
        stringRedisTemplate.convertAndSend("chat", String.valueOf(Math.random()));
    }

}
