package com.panhu.springcloud.controller;

import com.panhu.springcloud.service.IMesseageProvide;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private IMesseageProvide messeageProvide;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messeageProvide.send();
    }
}
