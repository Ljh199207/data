package com.data.redis.service;

import com.data.redis.dao.RedisDao;
import com.data.redis.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: ljh
 * @Date: 2018/9/4 14:46
 * @Description:
 */
@Service
public class RedisService {

    @Autowired
    private RedisDao redisDao;


    public  void save(Model model){
        RedisDao redisDao = new RedisDao();
        redisDao.save(model);
    }

}
