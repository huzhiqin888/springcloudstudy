package com.panhu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class paymentconsulcontroller {
    @Value("${server.port}")
    private String serverport;
    @RequestMapping("/payment/consul")
    private String paymentconsil(){
        return "springcloud with zk:"+serverport+"\t"+ UUID.randomUUID().toString();
    }
}
