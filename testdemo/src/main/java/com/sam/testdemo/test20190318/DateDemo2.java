package com.sam.testdemo.test20190318;

import java.time.LocalTime;
import java.time.ZoneId;

/**
 * LocalTime  获取时间
 *
 * @author Administrator
 */
public class DateDemo2 {

    public static void main(String[] args) {

        // 这个是不包含日期的
        LocalTime time = LocalTime.now();
        System.out.println("当前时间：" + time);
        System.out.println("获取时间字段："+time.getHour());

        LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
        System.out.println("指定时间：" + specificTime);

        // ZoneId从ID 获取实例
        LocalTime time_zoneId = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("时区列表时间：" + time_zoneId);

        // LocalTime从第二天的值中获取实例
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("获取实例：" + specificSecondTime);

        LocalTime mid = LocalTime.MIDNIGHT;
        System.out.println("当天开始的午夜时间："+mid);

        LocalTime nowTime = LocalTime.parse("12:30:30");
        LocalTime time1 = LocalTime.parse("12:35:30");
        System.out.println("检查此时间是否在指定时间之后："+time1.isAfter(nowTime));





    }
}