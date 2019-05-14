package com.sam.springbootjedis;

import com.sam.springbootjedis.config.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJedisApplicationTests {

    @Autowired
    RedisService redisService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void test(){
//        redisService.set("num","value22222");
        System.out.println(redisService.get("str"));
    }
}
