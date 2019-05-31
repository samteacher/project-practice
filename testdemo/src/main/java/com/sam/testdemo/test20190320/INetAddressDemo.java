package com.sam.testdemo.test20190320;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络协议API
 *
 * @author Administrator
 */
public class INetAddressDemo {

    public static void main(String[] args) {

        try {

            // 获取本机地址信息
            InetAddress localIp = InetAddress.getLocalHost();

            System.out.println("获取些IP地址的全限定域名（计算机全名）：" + localIp.getCanonicalHostName());
            System.out.println("IPV4地址（本机IP地址）：" + localIp.getHostAddress());
            System.out.println("获取主机名称：" + localIp.getHostName());
            System.out.println("toString = " + localIp.toString());
            System.out.println("测试是否可以达到该地址：" + localIp.isReachable(5000));
            System.out.println("获取InetAddress对象：" + InetAddress.getLocalHost());

            System.out.println("===============================");

            // 获取指定域名的地址信息
            InetAddress baiduIp = InetAddress.getByName("www.baidu.com");

            System.out.println("获取些IP地址的全限定域名（计算机全名）：" + baiduIp.getCanonicalHostName());
            System.out.println("IPV4地址（本机IP地址）：" + baiduIp.getHostAddress());
            System.out.println("获取主机名称：" + baiduIp.getHostName());
            System.out.println("toString = " + baiduIp.toString());
            System.out.println("测试是否可以达到该地址：" + baiduIp.isReachable(5000));

            System.out.println("===============================");

            // 获取指定原始IP地址信息
            InetAddress ip = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
            System.out.println("根据主机获取对应的InetAddress对象，参数Host可以是IP地址和域名：" + InetAddress.getByName("127.0.0.1"));

            System.out.println("获取些IP地址的全限定域名（计算机全名）：" + ip.getCanonicalHostName());
            System.out.println("IPV4地址（本机IP地址）：" + ip.getHostAddress());
            System.out.println("获取主机名称：" + ip.getHostName());
            System.out.println("toString = " + ip.toString());
            System.out.println("测试是否可以达到该地址：" + ip.isReachable(5000));


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
