package com.sam.springesspringdata.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author yuqiufu
 * @date 2019-06-05
 */
@Document(indexName = "elasticsearch", type = "node-101", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
public class Employee {

    @Id
    private String id;

    @Field
    private String firstName;

    @Field
    private String lastName;

    @Field
    private Integer age = 0;

    @Field
    private String about;

}
