package com.sam.redisdemo.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author yuqiufu
 * @since 2019-05-17
 */
@Configuration
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    protected RedisConfigVO redisConfigVO() {
        return new RedisConfigVO();
    }

    @Bean
    public RedisService createRedisService(RedisConfigVO configVO) {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();

        // 设置默认使用的数据库
        configuration.setDatabase(configVO.getDatabase());

        // 设置redis服务器的host或者ip地址
        configuration.setHostName(configVO.getHost());

        //设置redis的服务的端口号
        configuration.setPort(configVO.getPort());

        //设置密码
        configuration.setPassword(RedisPassword.of(configVO.getPassword()));

        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        // 设置最大实例总数
        genericObjectPoolConfig.setMaxTotal(configVO.getMaxactive());

        // 连接池中最大空闲的连接数
        genericObjectPoolConfig.setMaxIdle(configVO.getMaxidle());

        // 连接池中最小空闲的连接数
        genericObjectPoolConfig.setMinIdle(configVO.getMinidle());

        // 当连接池资源用尽后,调用者最大等待时间,一般不建议使用默认值
        genericObjectPoolConfig.setMaxWaitMillis((long) configVO.getMaxwait());

        // 向链接池借用连接时是否做连接有效性检测,无效连接会被移除,每次借用多一次执行一次ping命令
        genericObjectPoolConfig.setTestOnBorrow(true);

        // 向连接池借用连接时是否做连接空闲检测,空闲超时的连接会被移除
        genericObjectPoolConfig.setTestWhileIdle(true);

        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();

        // 指定JedisPoolConifig来修改默认的连接池构造器
        builder.poolConfig(genericObjectPoolConfig);

        // 通过构造器来构造jedis客户端配置
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(configuration, builder.build());
        connectionFactory.afterPropertiesSet();
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setHashValueSerializer(redisSerializer);
        redisTemplate.afterPropertiesSet();
        return new RedisService(redisTemplate);
    }

}
