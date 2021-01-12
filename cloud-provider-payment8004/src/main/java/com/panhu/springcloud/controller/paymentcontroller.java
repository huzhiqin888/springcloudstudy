package com.panhu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class paymentcontroller {
    @Value("${server.port}")
    private String serverpoet;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud with zk:"+serverpoet+"\t"+ UUID.randomUUID().toString();
    }
}
