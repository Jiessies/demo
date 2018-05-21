package com.example.demo.test;

import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;
    
    @GetMapping("/test1")
    public String doTest1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(param);
        return "hi" + param;
    }
    
    @GetMapping("/test2/{orderNo}")
    public String doTest2(@PathVariable String orderNo) {
        return orderService.findOrder(orderNo);
    }
    
}
