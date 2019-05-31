package com.sam.testdemo.test20190319;

import java.time.Duration;
import java.time.Instant;

/**
 * Duration 是在 Java 8中加入的，主要是用来计算日期，差值之类的。
 * Duration 被声明final（immutable），并且线程安全
 *
 * @author Administrator
 */
public class DateTime2 {

    /**
     * Duration与Period相对应，Period用于处理日期，而Duration计算时间差还可以处理具体的时间，
     * 也是通过调用其静态的between方法，该方法的签名是between(Temporal startInclusive, Temporal
     * endExclusive)，因此可以传入两个Instant的实例（Instant实现了Temporal接口），并可以以毫秒（toMillis）、
     * 秒（getSeconds）等多种形式表示得到的时间差
     *
     * @param args
     */
    public static void main(String[] args) {

        DurationTest();
    }

    public static void DurationTest() {

        //当前的时间
        Instant today = Instant.now();
        System.out.println("当时时间：" + today);

        //当前时间+10秒后的时间
        Instant ten_s_Time = today.plus(Duration.ofSeconds(10));
        System.out.println("当前时间+10秒后：" + ten_s_Time);

        //当前时间+125天后的时间
        Instant time_125_day = today.plus(Duration.ofDays(125));
        System.out.println("当前时间+125天后：" + time_125_day);

        System.out.println("以毫秒计的时间差：" + Duration.between(today, ten_s_Time).toMillis());

        System.out.println("以秒计的时间差：" + Duration.between(today, time_125_day).getSeconds());
    }
}
