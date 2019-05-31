package com.sam.testdemo.march_seven;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 序列化
 * JSON
 *
 * @author Administrator
 */
public class JSONTest {

    public static void main(String[] args) throws JsonProcessingException {

        Student student = new Student("张三", 18, 80.9d);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String str = mapper.writeValueAsString(student);
        System.out.println(str);
    }
}
