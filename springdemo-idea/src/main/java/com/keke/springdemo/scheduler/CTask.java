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
public class CTask implements IATask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 每隔2秒执行一次
     * fixedRate 执行频率，每隔多少时间就启动任务，不管该任务是否启动完成
     * 项目启动时，会立即执行任务。可以配合initialDelay一起使用（项目启动后延时执行任务）
     */
    @Scheduled(fixedRate = 2000)
    @Override
    public void aTask() {
        System.out.println(dateFormat.format(new Date()) + "*********C任务每2秒执行一次进入测试");
    }

}
