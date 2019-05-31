package com.sam.testdemo.march_five;

/**
 * 接口也可以是泛型
 *
 * @param <T>
 */
public interface Comparable<T> {

    public int compareTo(T o);

    public interface Comparator<T> {
        int compare(T o1, T o2);

        @Override
        boolean equals(Object obj);
    }

}
