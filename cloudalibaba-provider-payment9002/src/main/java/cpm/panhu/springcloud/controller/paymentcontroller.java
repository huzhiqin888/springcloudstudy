package cpm.panhu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paymentcontroller {
    @Value("${server.port}")
    private String serverport;

    @GetMapping("/payment/nacos/{id}")
    public String getpayment(@PathVariable("id") Integer id){
        return "nacos hello serverport: "+serverport+"id:"+id;
    }
}
