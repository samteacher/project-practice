package com.sam.testdemo.test20190320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URLConnection
 * URLConnection代表与URL指定的数据源的动态链接
 * 提供一些比URL更强的服务器交互控制的方法
 *
 * @author Administrator
 */
public class UrlConnectionDemo {

    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            // 构建URL对象
            URL myBook = new URL("http://39.106.197.170/membership/member-center/branches");

            // 由URL对象获取URLConnection对象
            URLConnection urlConnection = myBook.openConnection();

            //设置请求属性，字符集是UTF-8
            urlConnection.setRequestProperty("Charset", "UTF-8");

            // 由URLConnection获取输入流，并构造BufferedReader对象
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
