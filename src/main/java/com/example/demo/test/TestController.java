package com.example.demo.test;

import com.example.demo.rest.BisRestTemplate;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Created by huangmingjie on 2018/5/7.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    
    @Value("${param}")
    private String param;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private BisRestTemplate restTemplate;

    @Autowired
    private DynamicTask dynamicTask;

    public TestController(){
        System.out.println("init TestController");
    }

    @PostConstruct
    public void testPost(){
        System.out.println("init testPost");
    }

    @GetMapping("/test1")
    public String doTest1() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(param);
        System.out.println(dynamicTask.getName());
        return "hi" + param;
    }
    
    @GetMapping("/test2/{orderNo}")
    public String doTest2(@PathVariable String orderNo) {
        return orderService.findOrder(orderNo);
    }
    
    @GetMapping("/test3")
    public String rest(@RequestParam(value = "url") String url) {
        String response = restTemplate.get(url, null, null);
        return response;
    }
}
