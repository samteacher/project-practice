package com.sam.testdemo.test20190319;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 时间练习
 */
public class DateTest {

    public static void main(String[] args) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusDays(7);

        System.out.println("开始时间：" + startTime.format(df) + "，结束时间：" + endTime.format(df));

        LocalDateTime dateTest = LocalDateTime.parse("2018-02-30 12:12:12", df);
        System.out.println("时间自动转化：" + dateTest.toString());

        int daysNum = Period.between(startTime.toLocalDate(), endTime.toLocalDate()).getDays();
        int monthNum = Period.between(startTime.toLocalDate(), endTime.toLocalDate()).getMonths();
        System.out.println("相差天数：" + daysNum);
        System.out.println("相差月数：" + monthNum);

        System.out.println("当前时间向前推6天：" + LocalDateTime.now().minusDays(6));
        System.out.println("当前时间向前推6小时：" + LocalDateTime.now().minusHours(6));

    }
}
