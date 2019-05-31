package com.sam.testdemo.test20190320;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketDemo extends Thread {

    /**
     * 声明一个ServerSocket
     */
    ServerSocket serverSocket;

    /**
     * 计算
     */
    int num = 0;

    public ServerSocketDemo() {

        // 创建ServerSocket,用于监听28888端口是否有客户端的Socket
        try {

            serverSocket = new ServerSocket(28888);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 启动当前线程
        this.start();
        System.out.println("服务器开启...");

    }

    @Override
    public void run() {
        try {

            // 接收客户端的Socket
            Socket socket = serverSocket.accept();

            // 将Socket对应的输入流包装成BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 读客户端发送的信息并展示
            String line = br.readLine();
            System.out.println(line);


            // 将Socket对应的输出流包装成PrintStream
            PrintStream ps = new PrintStream(socket.getOutputStream());
            // 往客户端发送信息
            ps.println("你是第" + (++num) + "个访问服务器的用户！");

            ps.flush();
            br.close();
            ps.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new ServerSocketDemo();
    }

}
