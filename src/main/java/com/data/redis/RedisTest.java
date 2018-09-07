package com.data.redis;

import com.data.redis.model.Model;
import com.data.redis.service.RedisService;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther: ljh
 * @Date: 2018/9/4 14:44
 * @Description:
 */
public class RedisTest {

    public static void main(String[] args) {

        Model model = new Model();
        model.setId((long) (Math.random()*100));
        model.setCreateTimestamp(new Timestamp(new Date().getTime()));
        model.setAge(10);
        model.setName("test");

        RedisService redisService = new RedisService();
        redisService.save(model);
    }
}
