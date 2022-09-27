package com.kong.redis_springbootdemo;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RedisSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisSpringbootDemoApplication.class, args);
        if(true|false){
            List list = new ArrayList();
            list.size();
        }
    }

    @Test
    public void test(){
        System.out.println("123");
    }

}
