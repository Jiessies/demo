package com.example.demo.proxy;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "HELLO " + name;
    }
}
