package com.sam.testdemo.test20190316;

import java.io.*;

/**
 * BufferedWriter
 *
 * @author Administrator
 */
public class BufferedWriterTest {

    public static void main(String[] args) {

        File file = new File("D:/testIO/vuetest.html");
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }

        try (
                FileOutputStream fis = new FileOutputStream(file);
                OutputStreamWriter isr = new OutputStreamWriter(fis, "UTF-8");
                // 缓冲流
                BufferedWriter buffer = new BufferedWriter(isr);
        ) {

            buffer.write("15日的会议由人权理事会主席、塞内加尔常驻日内瓦代表苏克主持。中国外交部副部长乐玉成率中国政府代表团与会。中国常驻联合" +
                    "国日内瓦办事处和瑞士其他国际组织代表俞建华及中央司法体制改革领导小组办公室、中央统战部等有关单位，新疆、西藏自治区和香港、澳门特别行政区代表参会");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
