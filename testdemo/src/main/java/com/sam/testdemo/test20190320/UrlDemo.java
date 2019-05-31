package com.sam.testdemo.test20190320;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL类
 * 表示互联网上某一资源的地址
 *
 * @author Administrator
 */
public class UrlDemo {

    public static void main(String[] args) {

        try {

            URL myBook = new URL("http://39.106.197.170/membership/member-center/branches");

            System.out.println("获取协议Procotol：" + myBook.getProtocol());
            System.out.println("获取主机Host：" + myBook.getHost());
            System.out.println("获取端口Port：" + myBook.getPort());
            System.out.println("获取文件FileName：" + myBook.getFile());
            System.out.println("获取锚Ref：" + myBook.getRef());
            System.out.println("查询信息：" + myBook.getQuery());
            System.out.println("获取路径Path：" + myBook.getPort());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
