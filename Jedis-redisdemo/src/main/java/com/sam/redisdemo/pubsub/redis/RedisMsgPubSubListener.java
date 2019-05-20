package com.sam.redisdemo.pubsub.redis;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * redis发布订阅消息监听器
 *
 * @author yuqiufu
 * @since 2019-05-20
 */
public class RedisMsgPubSubListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(RedisMsgPubSubListener.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void onMessage(final Message message, final byte[] pattern) {
        RedisSerializer<?> serializer = redisTemplate.getValueSerializer();

        // message.getBody()是Redis的值，需要用redis的valueSerializer反序列化
        logger.info("Message receive-->pattern:{}，message: {},{}", new String(pattern), serializer.deserialize(message.getBody()), redisTemplate.getStringSerializer().deserialize(message.getChannel()));
        logger.info(message.toString());

        JSONObject json = JSONObject.parseObject(serializer.deserialize(message.getBody()).toString());
        String cutomerId = json.getString("cutomerId");

        //可以与WebSocket结合使用，解决分布式服务中，共享Session
        if (StringUtils.isNotEmpty(cutomerId)) {
            logger.info("cutomerId: {}，消息:{}", cutomerId, message.toString());
        } else {
            logger.info("cutomerId 为空，无法推送给对应的客户端，消息:{}", message.toString());
        }
    }

}
