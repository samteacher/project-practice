package com.sam.testdemo.march_four;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * StringBuffer
 *
 * @author Administrator
 */
public class StringBufferTest {

    /**
     * StringBuffer
     *
     * @param args
     */
    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("老马说编程");
        buffer.append(",探索编程本质");
//        buffer.append(true);
//        buffer.append(11);
//        buffer.append(127.58);
//        buffer.append('a');
//        buffer.append(127.01F);

        // public StringBuilder insert(int offset, String str)
        // 指定索引offset处插入字符串str，原来的字符后移，offset为0表示在开头插，为length()表示在结尾插
        buffer.insert(0, "关注");
        buffer.insert(buffer.length(), "老马和你一起探索编程本质");

        buffer.replace(3, 5, "Java");
        System.out.println(buffer.toString());

        System.out.println(buffer.toString());
        System.out.println(buffer);

        // 挪动位置调用了System.arraycopy方法，这是个比较常用的方法
        int[] arr = new int[]{1, 2, 3, 4};
        System.arraycopy(arr, 1, arr, 0, 3);
        System.out.println(arr[0] + "," + arr[1] + "," + arr[2]);


        // Arrays的toString方法可以方便的输出一个数组的字符串形式，方便查看，它有九个重载的方法，包括八种基本类型数组和一个对象类型数组
        int[] arr1 = {9, 8, 3, 4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr));

        // 时间   Calendar 年历
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 03, 04, 19, 46, 20);
        System.out.println(DateFormat.getDateTimeInstance().format(calendar.getTime()));
        System.out.println(DateFormat.getDateInstance().format(calendar.getTime()));
        System.out.println(DateFormat.getTimeInstance().format(calendar.getTime()));


        // SimpleDateFormat是DateFormat的子类，相比DateFormat，它的一个主要不同是，它可以接受一个自定义的模式(pattern)作为参数，这个模式规定了Date的字符串形式。先看个例子：

        // yyyy：表示四位的年
        // MM：表示月，两位数表示
        // dd：表示日，两位数表示
        // HH：表示24小时制的小时数，两位数表示
        // mm：表示分钟，两位数表示
        // ss：表示秒，两位数表示
        // E：表示星期几

        // Calendar操作比较啰嗦臃肿
        // Calendar API的设计不是很成功，一些简单的操作都需要多次方法调用，写很多代码，比较啰嗦臃肿。
        // 另外，Calendar难以进行比较复杂的日期操作，比如，计算两个日期之间有多少个月，根据生日计算年龄，计算下个月的第一个周一等

        Calendar calendar2 = Calendar.getInstance();
        //2016-08-15 14:15:20
        calendar2.set(2016, 07, 15, 14, 15, 20);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH时mm分ss秒");
        System.out.println(sdf.format(calendar2.getTime()));


    }
}
