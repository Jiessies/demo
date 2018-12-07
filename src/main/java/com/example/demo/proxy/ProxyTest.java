package com.example.demo.proxy;

public class ProxyTest {
    public static void main(String[] args) {
//        HelloServiceProxy serviceProxy = new HelloServiceProxy();
//        HelloService helloService = (HelloService) serviceProxy.bind(new HelloServiceImpl());
//        helloService.sayHello("huangmingjie");

        HelloServiceCgLib cgLib = new HelloServiceCgLib();
        HelloService helloService = (HelloService) cgLib.getInstance(new HelloServiceImpl());
        helloService.sayHello("sdgsagad");
    }
}
