package com.panhu.springcloud.contriller;

import com.panhu.springcloud.entities.CommonResult;
import com.panhu.springcloud.entities.Payment;
import com.panhu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class orderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/customer/feign/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}