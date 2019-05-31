package com.sam.testdemo.test20190319;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Period
 *
 * @author Administrator
 */
public class DateTime3 {

    public static void main(String[] args) {
        PeriodTest(2019, Month.MARCH, 1);
    }

    /**
     * 在后期使用Period.between（）方法来获取，相差天数、相差月数的时候，
     * 发现只能计算同月的天数、同年的月数，不能计算隔月的天数以及隔年的月数！！！
     *
     * @param year
     * @param month
     * @param dayOfMonth
     */
    public static void PeriodTest(int year, Month month, int dayOfMonth) {

        LocalDate today = LocalDate.now();

        System.out.println("当前日期：" + today);
        LocalDate oldDate = LocalDate.of(year, month, dayOfMonth);
        System.out.println("之前日期：" + oldDate);

        Period p = Period.between(oldDate, today);
        System.out.printf("目标日期距离今天的时间差：%d 年 %d 个月 %d 天\n", p.getYears(), p.getMonths(), p.getDays());
    }
}