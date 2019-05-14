package com.sam.springbootjedis.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisConfigVO {

    private Integer database;
    private String host;
    private String password;
    private Integer port;
    private Long timeout;
    private Integer maxactive;
    private Integer maxwait;
    private Integer maxidle;
    private Integer minidle;

}
