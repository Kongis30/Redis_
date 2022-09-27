package com.kong.redis_springbootdemo.Jedis.VertifyCode_;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-08-31 19:26
 * @Version: 1.0
 * @Description:
 */

public class PhoneCode {

    public static void main(String[] args) {
//        verifycode("17620");
//        getRedisCode("17620","725747");
        System.out.println("success idea..");

    }

    //生产验证码
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for (int i=0;i<6;i++){
            int i1 = random.nextInt(10);
            code += i1;
        }
        System.out.println(code);
        return code;
    }

    //发送验证码
    public static void verifycode(String phone){
        //发送次数key 验证码key
        String countKey = "VerifyCode" + phone + ":count";
        String codeKey = "VerifyCode" + phone + ":code";
        Jedis jedis = new Jedis("192.168.139.132",6379);

        String count = jedis.get(countKey);
        if (count==null){
            jedis.setex(countKey, 24*60*60 ,"1");
        }else if (Integer.parseInt(count)<=2){
            jedis.incr(countKey);
        }else {
            System.out.println("当天发送次数超过三次....");
            jedis.close();
            return;
        }

        //生成验证码 并存入redis，设置120s有效
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
    }

    //验证码校验
    public static boolean getRedisCode(String phone,String  code){
        Jedis jedis = new Jedis("192.168.139.132",6379);
        String codeKey = "VerifyCode" + phone + ":code";
        String vcode = jedis.get(codeKey);
        if (code.equals(vcode)){
            System.out.println("success");
            return true;
        }else {
            System.out.println("fail");
            return false;
        }
    }

    @Test
    public void test(){
//        verifycode("17620");
//        getRedisCode("17620","725747");
        System.out.println("success idea..");
    }
}