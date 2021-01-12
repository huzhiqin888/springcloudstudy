package com.panhu.springcloud.service.impl;

import com.panhu.springcloud.dao.PaymentMapper;

import com.panhu.springcloud.service.Paymentservice;


import com.panhu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class Paymentserviceimpl implements Paymentservice {
    @Resource
    private PaymentMapper paymentMapper;


    @Override
    public int creat(Payment payment) {
        return paymentMapper.creat(payment);
    }

    @Override
    public Payment getPaymentbyId(Long id) {
        return paymentMapper.getPaymentbyId(id);
    }
}
