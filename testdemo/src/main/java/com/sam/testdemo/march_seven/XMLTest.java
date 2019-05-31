package com.sam.testdemo.march_seven;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * XML
 * 序列化
 *
 * @author Administrator
 */
public class XMLTest {

    public static void main(String[] args) {
        try {
            Student student = new Student("张三", 18, 80.9d);
            ObjectMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String str = mapper.writeValueAsString(student);
            mapper.writeValue(new File("student.xml"), student);
            System.out.println(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
