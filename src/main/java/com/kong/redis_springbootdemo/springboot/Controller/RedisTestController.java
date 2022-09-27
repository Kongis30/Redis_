package com.kong.redis_springbootdemo.springboot.Controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Kong
 * @License: (C) Copyright 2005-2019, xxx Corporation Limited.
 * @Contact: xxx@xxx.com
 * @Date: 2022-09-01 16:40
 * @Version: 1.0
 * @Description:
 */

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping
    public String redisTest(){
        redisTemplate.opsForValue().set("name", "jack");
        String name = (String) redisTemplate.opsForValue().get("name");

        return name;
    }

    @Test
    public void test(){
        int[] nums1 = new int[]{2};
        int[] nums2 = new int[]{};

        int i=0,j=0,t=0;
        int m=nums1.length,n=nums2.length;
        int[] num = new int[n+m];
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                num[t] = nums1[i++];
            }else{
                num[t] = nums2[j++];
            }
            t++;
        }
        while (i<m){
            num[t++] = nums1[i++];
        }

        while (j<n){
            num[t++] = nums2[j++];
        }

        int l = (num.length - 1)/2;
        System.out.println(l);
        if(num.length%2==0){
            System.out.println((double) num[l]);
            System.out.println((double) num[l+1]);

            System.out.println(((double) num[l] + (double) num[l + 1]) / 2);
        }else{
            System.out.println((double) num[l]);
        }
        String srt = "";
        srt.length();
        
    }
}