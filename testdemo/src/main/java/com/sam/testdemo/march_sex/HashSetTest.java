package com.sam.testdemo.march_sex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * HashSet
 * 可以高效的添加、删除元素、判断元素是否存在
 *
 * @author Administrator
 */
public class HashSetTest {

    public static void main(String[] args) {

        /**
         * Set表示的是没有重复元素、且不保证顺序的容器接口，扩展了Collection
         *
         * HashSet有很多应用场景，比如说：
         * 排重，如果对排重后的元素没有顺序要求，则HashSet可以方便的用于排重。
         * 保存特殊值，Set可以用于保存各种特殊值，程序处理用户请求或数据记录时，根据是否为特殊值，进行特殊处理，比如保存IP地址的黑名单或白名单。
         * 集合运算，使用Set可以方便的进行数学集合中的运算，如交集、并集等运算，这些运算有一些很现实的意义。比如用户标签计算，
         * 每个用户都有一些标签，两个用户的标签交集就表示他们的共同特征，交集大小除以并集大小可以表示他们的相似长度。
         */

        /**
         * public HashSet() {
         *     map = new HashMap<>();
         * }
         * HashSet内部是用HashMap实现的
         */
        Set<String> set = new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.addAll(Arrays.asList(new String[]{"hello", "老马"}));

        for (String s : set) {
            System.out.println(s + " ");
        }

    }
}
