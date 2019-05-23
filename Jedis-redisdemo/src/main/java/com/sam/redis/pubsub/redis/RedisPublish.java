package com.sam.redis.pubsub.redis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuqiufu
 * @since 2019-05-21
 */
@RestController
@RequestMapping("redis")
public class RedisPublish {

//    private int m = 0;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @RequestMapping("publish")
//    public String publish() {
//        int index = m;
//        for (int i = m; i < index + 10; i++) {
//            stringRedisTemplate.convertAndSend("mytopic", "这是我发第" + i + "条的消息啊");
//        }
//        return "结束";
//    }
}
