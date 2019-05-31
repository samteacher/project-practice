package com.sam.testdemo.march_five;

/**
 * 泛型
 * 泛型是计算机程序中一种重要的思维方式，它将数据结构和算法与数据类型相分离,
 * 使得同一套数据结构和算法，能够应用于各种数据类型，而且还可以保证类型安全，提高可读性。
 *
 * @param <T>
 */
public class Pair<T> {

    T first;
    T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public static <T> int indexOf(T[] arr, T elm) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(elm)) {
                return i;
            }
        }
        return -1;
    }

    // 与泛型类一样，类型参数可以有多个，多个以逗号分隔
//    public static <U, V> Pair<U, V> makePair(U first, V second) {
//        Pair<U, V> pair = new Pair<>(first, second);
//        return pair;
//    }

}
