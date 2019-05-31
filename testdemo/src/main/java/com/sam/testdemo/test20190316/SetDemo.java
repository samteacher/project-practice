package com.sam.testdemo.test20190316;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 接口
 * Set集合
 *
 * @author Administrator
 */
public class SetDemo {

    private static final int INTEGER_NUM = 100000;

    /**
     * 多态实现
     * <p>
     * 接口
     *
     * @param args
     */
    public static void main(String[] args) {

        Set<Integer> nums = new HashSet<>();
        nums.add(11);

        Set<Integer> nums2 = new HashSet<>();
        nums.add(22);

        // addAll()  将另一个集合塞到集合中
        nums2.addAll(nums);
        for (Integer num : nums2) {
            System.out.println("遍历值：" + num);
        }

        // clear()  清空
        nums.clear();
        System.out.println("清除后：" + nums.size());

        // size() 个数
        System.out.println("新集合长度：" + nums2.size());

        // toArray 转数组
        Object[] strs = nums2.toArray();
        for (Object str : strs) {
            System.out.println("集合转数组：" + str);
        }

        // 迭代 while循环
        Iterator<Integer> iters = nums2.iterator();
        while (iters.hasNext()) {
            System.out.println("集合迭代值：" + iters.next());
        }

        System.out.println("是否包含此内容：" + nums2.contains(22));


//        for (int i = 0; i < INTEGER_NUM; i++) {
//            nums.add(i);
//        }
//        for (Integer num : nums) {
//            // 是无序的
//            System.out.print(num + "\t");
//        }

//        nums.add(12);
//        nums.add(30);
//        nums.add(15);
//        nums.add(8);
//        nums.add(12);
//        for (Integer num: nums) {
//            // 8	12	30	15  去重了
//            System.out.print(num+"\t");
//        }


        // 没有任何类型的约束范围 这种写法在开发中没有任何意义
        // 使用泛型约束
//        Set age = new HashSet();
//        age.add(12);
//        age.add("keke");
//        age.add(true);
//        age.add('a');
//        age.add(12.3F);
//        age.add(89L);

        // 父类
//        Set hashSet = new HashSet<>();

        // HashSet的子类  可以用自己的也可以用父类的
//        Set linkedHashSet = new LinkedHashSet();

//        Set treeSet = new TreeSet();


    }

}
