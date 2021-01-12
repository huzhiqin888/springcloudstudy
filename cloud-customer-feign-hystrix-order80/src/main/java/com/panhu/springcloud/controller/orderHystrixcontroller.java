package com.panhu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.panhu.springcloud.service.paymentHystrixservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "gobal_paymentInfo_timeoutHandler")
public class orderHystrixcontroller {
    @Resource
    private paymentHystrixservice paymentHystrixservice;
    @GetMapping("/consumer/payment/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id")Integer id){
        String result=paymentHystrixservice.paymentInfo_OK(id);
        return result;
    };
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
/*    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            //设置峰值，超过 1.5 秒，就会调用兜底方法
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        int a=10/0;
        String result=paymentHystrixservice.paymentInfo_Timeout(id);
        return result;
    }
    public String paymentInfo_timeoutHandler(@PathVariable("id")Integer id){
        return "我是消费者80，对方支付系统繁忙，10秒后在重新测试";
    }

    //全局报错异常处理
    public String gobal_paymentInfo_timeoutHandler(){
        return "这是全局报错异常处理";
    }
}
