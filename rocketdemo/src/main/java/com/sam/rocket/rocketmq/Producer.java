package com.sam.rocket.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author yuqiufu
 * @since 2019-05-25
 * 生产者
 */
public class Producer {


    /**
     * RocketMQ通过 MessageQueueSelector 中实现的算法来确定消息发送到哪一个队列上
     * RocketMQ默认提供了两种 MessageQueueSelector 实现：随机/Hash
     * 当然你可以根据业务实现自己的 MessageQueueSelector 来决定消息按照何种策略发送到消息队列中
     */
    public static void main(String[] args) throws Exception {

        //创建一个消息生产者，并设置一个消息生产者组
        DefaultMQProducer producer = new DefaultMQProducer("niwei_producer_group");

        //指定 NameServer 地址
        producer.setNamesrvAddr("localhost:9876");

        //初始化 Producer，整个应用生命周期内只需要初始化一次
        producer.start();

        for (int i = 0; i < 100; i++) {
            //创建一条消息对象，指定其主题、标签和消息内容
            Message msg = new Message(
                    // 消息主题名
                    "topic_example_java",
                    // 消息标签
                    "TagA",
                    // 消息内容
                    ("Hello Java demo RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );

            //发送消息并返回结果
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }

        // 一旦生产者实例不再被使用则将其关闭，包括清理资源，关闭网络连接等
        producer.shutdown();
    }

}
