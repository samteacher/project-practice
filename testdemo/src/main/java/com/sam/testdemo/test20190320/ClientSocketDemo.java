package com.sam.testdemo.test20190320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author Administrator
 */
public class ClientSocketDemo {

    public static void main(String[] args) {

        try {
            // 创建链接到本机，端口为28888的Socket对象
            Socket socket = new Socket("127.0.0.1", 28888);

            // 将Socket对应的输出流包装成PrintStream
            PrintStream ps = new PrintStream(socket.getOutputStream());
            // 发送信息
            ps.println("我是kekesam");
            ps.flush();


            // 将Socket对应的输出流包装成BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 读服务器返回的信息并提示
            String line = br.readLine();
            System.out.println("来自服务器的信息：" + line);

            br.close();
            ps.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
