package com.sam.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者 Consumer
 *
 * @author yuqiufu
 * @since 2019-06-17
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    public List<String> getConsumerAll() {
        return restTemplate.getForObject("http://service-provider/provider/getProviderAll", List.class);
    }

}
