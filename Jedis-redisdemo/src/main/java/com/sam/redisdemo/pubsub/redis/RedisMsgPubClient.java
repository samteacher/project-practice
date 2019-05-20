package com.sam.redisdemo.pubsub.redis;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 发布者
 *
 * @author yuqiufu
 * @since 2019-05-20
 */
@Controller
@RequestMapping(value = "/redisMsgPubClientBySpring")
public class RedisMsgPubClient {

    private Logger logger = LoggerFactory.getLogger(RedisMsgPubClient.class);

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @RequestMapping
    @ResponseBody
    public String pubMsg(HttpServletRequest request, HttpServletResponse response) {

        String cutomerId = request.getParameter("cutomerId").toString();
        String msg = request.getParameter("msg").toString();
        logger.info("发布消息：{}", request.getParameter("msg").toString());

        JSONObject json = new JSONObject();
        json.put("cutomerId", cutomerId);
        json.put("msg", msg);

        redisTemplate.convertAndSend("WEB_SOCKET:LOTTERY", json);
        return "成功";
    }

}
