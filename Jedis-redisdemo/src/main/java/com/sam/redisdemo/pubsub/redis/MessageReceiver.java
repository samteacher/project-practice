package com.sam.redisdemo.pubsub.redis;

import org.springframework.stereotype.Component;

/**
 * 消息处理器
 *
 * @author yuqiufu
 * @since 2019-05-21
 */
@Component
public class MessageReceiver {

    /**
     * 接收消息的方法
     */
    public void receiveMessage(String message) {
        System.out.println("---------收到一条消息：" + message);
    }

}
