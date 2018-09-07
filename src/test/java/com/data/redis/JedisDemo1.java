package com.data.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther: ljh
 * @Date: 2018/9/3 14:09
 * @Description:
 */
public class JedisDemo1 {


    public  void demo1(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("name","liang");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
    /**
     *
     * 功能描述: 连接池
     *
     * @param: []
     * @return: void
     * @auther: ljh
     * @date: 2018/9/3 14:14
     */
    @Test
    public  void demo2(){
        //获取连接池配置对象
        JedisPoolConfig jedisPoolConfig= new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(30);
        //设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        //获取连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
        Jedis jedis = null;
        //通过连接池获取连接
        jedis  = jedisPool.getResource();
        jedis.set("name","Hai");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
        jedisPool.close();

    }

}
