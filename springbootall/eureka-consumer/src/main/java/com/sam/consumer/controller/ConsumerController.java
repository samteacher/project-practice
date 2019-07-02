package com.sam.consumer.controller;

import com.sam.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 消费者
 *
 * @author yuqiufu
 * @since 2019-06-17
 */
@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/getConsumerAll")
    public List<String> getConsumerAll() {
        System.out.println("会员服务正在被消费.......");
        return consumerService.getConsumerAll();
    }

    @GetMapping("/getConsumerServiceApi")
    public String getConsumerServiceApi(){
        return "this is 消费者";
    }

}
