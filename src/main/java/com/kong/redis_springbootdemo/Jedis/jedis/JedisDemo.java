package com.kong.redis_springbootdemo.Jedis.jedis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-08-31 16:34
 * @Version: 1.0
 * @Description:
 */

public class JedisDemo {
    public static void main(String[] args) {
        System.out.println("++++++++++++++++++");
        Jedis jedis = new Jedis("192.168.139.132",6379);

        //添加key
        jedis.set("k1", "1");
        //获取key
        String k1 = jedis.get("k1");
        System.out.println(k1);

        //存取多个键值
        jedis.mset("k2","2","k3","3");
        List<String> mget = jedis.mget("k1", "k2", "k3");
        System.out.println(mget);

        Set<String> value = jedis.keys("*");
        System.out.println(value);
        System.out.println("++++++++++++++++++");
    }
}