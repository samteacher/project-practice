package com.sam.redis.pubsub.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

/**
 * redis发布订阅消息监听器
 *
 * @author yuqiufu
 * @since 2019-05-20
 */
public class JedisMsgPubSubListener extends JedisPubSub {

    private Logger logger = LoggerFactory.getLogger(JedisMsgPubSubListener.class);

    /**
     * 退订频道
     */
    @Override
    public void unsubscribe() {
        super.unsubscribe();
    }

    /**
     * 退订多个频道
     *
     * @param channels
     */
    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    /**
     * 订阅频道
     *
     * @param channels
     */
    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    /**
     * 订阅模式频道
     *
     * @param patterns
     */
    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    /**
     * 退订模式频道
     */
    @Override
    public void punsubscribe() {
        super.punsubscribe();
    }

    /**
     * 退订多个模式频道
     *
     * @param patterns
     */
    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    /**
     * 监听到订阅频道接受到消息时的回调
     *
     * @param channel
     * @param message
     */
    @Override
    public void onMessage(String channel, String message) {
        logger.info("onMessage: channel[{}], message[{}]", channel, message);
    }

    /**
     * 监听到订阅模式接受到消息时的回调
     *
     * @param pattern
     * @param channel
     * @param message
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        logger.info("onPMessage: pattern[{}], channel[{}], message[{}]", pattern, channel, message);
    }

    /**
     * 订阅频道时的回调
     *
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        logger.info("onSubscribe: channel[{}], subscribedChannels[{}]", channel, subscribedChannels);
    }

    /**
     * 取消订阅模式时的回调
     *
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        logger.info("onPUnsubscribe: pattern[{}], subscribedChannels[{}]", pattern, subscribedChannels);
    }

    /**
     * 订阅频道模式时的回调
     *
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        logger.info("onPSubscribe: pattern[{}], subscribedChannels[{}]", pattern, subscribedChannels);
    }

    /**
     * 取消订阅频道时的回调
     *
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        logger.info("channel:{} is been subscribed:{}", channel, subscribedChannels);
    }

}
