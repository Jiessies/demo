package com.example.demo.test;

import org.springframework.stereotype.Service;

/**
 * Created by huangmingjie on 2018/6/9.
 */
@Service
public class DynamicTask {

    public String getName(){
        return "huangmingeji";
    }
    public DynamicTask(){
        System.out.println("init DynamicTask");
    }
}
