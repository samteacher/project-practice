package com.keke.springdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 * @since 2019-06-11
 */
@Component
public class ATask implements IATask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 每10秒执行一次
     * 设置时分秒等具体的定时 ,有自己的表达式
     */
    @Scheduled(cron = "0/10 * *  * * ? ")
    @Override
    public void aTask() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(dateFormat.format(new Date()) + "*********A任务每10秒执行一次进入测试");
    }

    /**
     * spring的定时任务默认是单线程，多个任务执行起来时间会有问题（B任务会因为A任务执行起来需要20S而被延后20S执行）
     */
}
