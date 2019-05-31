package com.sam.testdemo.test20190318;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * LocalDate  获取日期
 *
 * @author Administrator
 */
public class DateDemo {

    public static void main(String[] args) {

        // LocalDate.now() 获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("当前日期：" + today);

        //通过提供输入参数创建LocalDate  年-月-日
        LocalDate param_2014 = LocalDate.of(2014, Month.JULY, 28);
        System.out.println("具体日期：" + param_2014);
        System.out.println("获取年：" + param_2014.getYear());
        System.out.println("获取月：" + param_2014.getMonth());
        System.out.println("获取月份的值：" + param_2014.getMonthValue());
        System.out.println("获取当前Day：" + param_2014.getDayOfMonth());
        System.out.println("获取本周周几：" + param_2014.getDayOfWeek());
        System.out.println("返回此日期表示的月份长度：" + param_2014.lengthOfMonth());
        System.out.println("是否是闰年：" + param_2014.isLeapYear());

        // ZoneId从ID 获取实例
        LocalDate zoneId_today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("ZoneId从ID：" + zoneId_today);

        // 1970-01-01 纪元日
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("从纪元日计数中起100天：" + dateFromBase);

        LocalDate start_2019 = LocalDate.ofYearDay(2019, 100);
        System.out.println("2019年第100天：" + start_2019);

        // 判断日期
        LocalDate date = LocalDate.of(2019, 3, 19);
        LocalDate date1 = LocalDate.now();
        System.out.println("今天的日期是2019-03-18嘛：" + date.equals(date1));


        //尝试通过提供无效输入来创建日期
//        LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        // 报错 java.time.DateTimeException
//        System.out.println(feb29_2014);


    }
}
