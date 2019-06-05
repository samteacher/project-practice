package com.sam.springesjest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.searchbox.annotations.JestId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuqiufu
 * @since 2019-06-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    /**
     * 商品自增id
     */
    @JestId
    private Long id;

    /**
     * 商品编码
     */
    private String name;

    /**
     * 商品标题
     */
    private Integer age;

    /**
     * 商品副标题
     */
    private String description;

    /**
     * 商品标签
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

}
