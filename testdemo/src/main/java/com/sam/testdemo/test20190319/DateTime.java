package com.sam.testdemo.test20190319;

import java.time.*;

/**
 * LocalDateTime
 *
 * @author Administrator
 */
public class DateTime {

    public static void main(String[] args) {


        LocalDateTime today = LocalDateTime.now();
        System.out.println("当前日期：" + today);
        System.out.println("添加指定的天数：" + today.plusDays(10));
        System.out.println("添加指定的小时数：" + today.plusHours(7));
        // LocalDateTime plusMinutes(long minutesToAdd) 添加指定分钟数
        // LocalDateTime plusMonths(long monthsToAdd)  添加指定的月份数
        // LocalDateTime plusWeeks(long weeksToAdd)  添加指定的周数
        // LocalDate toLocalDate() 获取此日期时间的LocalDate部分
        // LocalTime toLocalTime() 获取此日期时间的LocalTime部分

        System.out.println("LocalDate部分："+today.toLocalDate());
        System.out.println("toLocalTime部分："+today.toLocalTime());

        // 使用LocalDate和LocalTime创建当前日期
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("当前日期：" + today);

        //通过提供输入参数创建LocalDateTime
        LocalDateTime specificDate = LocalDateTime.of(2019, Month.MARCH, 19, 8, 50, 30);
        System.out.println("指定时间：" + specificDate);

        // 从指定时区的系统时钟获取当前日期时间
        LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("获取实例：" + todayKolkata);

        //从1970-01-01T00:00:00Z的纪元获得LocalDateTime的实例  ofEpochSecond 添加一个代表秒数的值
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("纪元实例：" + dateFromBase);


    }
}
