package com.panhu.springcloud.service.impl;

import com.panhu.springcloud.service.paymentHystrixservice;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements paymentHystrixservice {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK 出问题啦，等会在来叭";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "paymentInfo_Timeout 出问题啦，等会在来叭";
    }
}
