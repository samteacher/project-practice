package com.sam.testdemo.test20190318;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

/**
 * TreeSet集合
 *
 * @author Administrator
 */
public class SetDemo3 {

    /**
     * 自然排序 默认升序
     *
     * @param args
     */
    public static void main(String[] args) throws ParseException {


        TreeSet<Date> dates = new TreeSet<Date>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                // 晚于
//                if (o2.after(o1)) {

                // 早于
              if (o2.before(o1)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        dates.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-12-12 12:12:11"));
        dates.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-08-12 01:12:08"));
        dates.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-03-12 11:12:12"));
        dates.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-02-12 01:12:10"));
        dates.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-10-12 02:11:22"));
        dates.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2005-01-12 11:12:24"));

        for (Date date : dates) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        }


        // Comparator排序器
//        TreeSet<String> strs = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o2.length() > o1.length()) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });
//
//        // 根据code个数排序
//        strs.add("java");
//        strs.add("我K你");
//        strs.add("我是samkeke");
//        strs.add("你好嘛");
//        strs.add("为为");
//        strs.add("啊");
//        strs.add("哦");

//        strs.add("A");
//        strs.add("B");
//        strs.add("C");
//        strs.add("D");
//        strs.add("E");
//        strs.add("F");
//        strs.add("G");
//
//        for (String str : strs) {
//            System.out.println(str);
//        }



        // SortedMap 顶层
////        TreeSet<Integer> nums = new TreeSet<>(new IntegerComparator(false));
//        TreeSet<Integer> nums = new TreeSet<>();
//        nums.add(1);
//        nums.add(32);
//        nums.add(18);
//        nums.add(24);
//        nums.add(15);
//        nums.add(98);
//        nums.add(9);
//
//        // 从小到大默认排序
//        for (Integer num : nums) {
//            System.out.println(num);
//        }

    }
}
