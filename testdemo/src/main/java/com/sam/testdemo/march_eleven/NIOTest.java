package com.sam.testdemo.march_eleven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

    public static void main(String[] args) throws IOException {


        /**
         * 两个重要的组件：Buffer和Channel
         * Buffer 是NIO中最核心的部分
         * 创建Buffer的两种方式
         */

        // 创建方式一
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 创建方式二
        byte array[] = new byte[1024];
        ByteBuffer byteBuffer = ByteBuffer.wrap(array);

        /**
         * 重置和清空Buffer缓冲区
         * public final Buffer rewind()
         * public final Buffer clear()
         * public final Buffer flip()
         *
         * write(buffer) 从Buffer读取数据定入Channel
         * rewind() 回滚Buffer
         * get(array) 将Buffer的有效数据复制到数组中
         *
         * claer() 为读入数据到Buffer做准备
         * read(buffer) 从通道读入数据
         */
    }

    public static void nioCityFile(String resource, String desctination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(desctination);
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        // 读入数据缓冲
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();
            int len = readChannel.read(buffer);
            if (len == -1) {
                break;
            }
            // 重置 Buffer中的 position
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }
}
