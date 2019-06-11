package com.keke.springdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuqiufu
 * @since 2019-06-11
 */
@Component
public class BTask implements IATask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 每5秒执行一次
     * 设置时分秒等具体的定时 ,有自己的表达式
     */
    @Scheduled(cron = "0/5 * *  * * ? ")
    @Override
    public void aTask() {
        System.out.println(dateFormat.format(new Date()) + "*********B任务每5秒执行一次进入测试");
    }

}
