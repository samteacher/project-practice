package com.sam.testdemo.feb_tf;


public class Test {

    public static String getValue(int score) {
        if (score > 60) {
            return "优秀";
        } else if (score > 80) {
            return "良好";
        } else {
            return "及格";
        }
    }

    public static int max(int min, int... a) {
        int max = min;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(0));
        System.out.println(max(0, 2));
        System.out.println(max(0, 2, 4));
        System.out.println(max(0, 2, 4, 5));


//        String a = "abc";
//        a = "cdb";
//        System.out.println(a);

//        String[] arr = {"A", "B", "C", "D"};
//        for (int i = arr.length - 1; i >= 0; i--) {
//            System.out.println(arr[i]);
//        }

//        for (String element : arr) {
//            System.out.println(element);
//        }

//        int i = 0;
//        for (; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

//        Scanner reader = new Scanner(System.in);
//        int password = 6789;
//        int num = 0;
//        do{
//            System.out.println("please input password");
//            num = reader.nextInt();
//        }while(num!=password);
//        System.out.println("correct");
//        reader.close();

//        System.out.println(getValue(90));


//        long intNum = 2147483647;
//        // 超出Int类型最大值需要在末尾在上小写或大写的L
//        long longNum = 2147483648L;
//
//        float a = 2147483647;
//
//        // 第一种和第二种都是预先知道数组的内容，而第三种是先分配长度，然后再给每个元素赋值
//        int[] intArr = {1,2,3};
//        int[] intArr2 = new int[]{1,2,3};
//        int[] intArr3 = new int[3];
//        intArr3[0]=1;
//        intArr3[1]=2;
//        intArr3[2]=3;
//        // 1 即使没有给每个元素赋值，每个元素也都有一个默认值，这个默认值跟数组类型有关。数值类型的值为0
//        System.out.println(intArr3[0]);
//        System.out.println(intArr3.length);

//        int[] arrA = {1,2,3};
//        int[] arrB = {4,5,6,7};
//        arrA = arrB;
//        System.out.println(arrA[0]);

//        int a = 2147483647;
//        System.out.println(a  + 1);

//        float f = 0.1f * 0.1f;
//        System.out.println(f);

//        BigDecimal bigDecimal = new BigDecimal(2);
//        BigDecimal bDouble = new BigDecimal(2.3);
//        BigDecimal bString = new BigDecimal("2.3");
//        System.out.println("bigDecimal=" + bigDecimal);
//        System.out.println("bDouble=" + bDouble);
//        System.out.println("bString=" + bString);

//        BigDecimal bDouble1 = BigDecimal.valueOf(2.6);
//        BigDecimal bDouble2 = new BigDecimal(Double.toString(2.6));
//        System.out.println("bDouble1=" + bDouble1);
//        System.out.println("bDouble2=" + bDouble2);

//        BigDecimal a = new BigDecimal("4.5635");
//        //保留3位小数，且四舍五入
//        a = a.setScale(3, RoundingMode.HALF_UP);
//        System.out.println(a);

//        byte g = 'a';
//        char h = (char) g;
//        char i = 85;
//        System.out.println(g);
//        System.out.println(h);
//        System.out.println(i);

//        char a = 'a';
//        char b = '马';
//        char d = 39532;
//        char e = 0x9a6c;
//        char f = '\u9a6c';
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(d);
//        System.out.println(e);
//        System.out.println(f);

//        char c = '马';
//        System.out.println(Integer.toBinaryString(c));

//        byte a = 1;
//        byte b = 3;
//        // 报错是因为上面a、b已经自动提升为int类型
//        // 解决方案  byte c = (byte)(a+b) 显示强转类型
//        byte c = a + b;
//        byte d = 1 + 3;

//        byte a = 1;
//        byte b = 3;
//        byte c = (byte)(a + b);

    }
}
