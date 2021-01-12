package com.panhu.springcloud.service;



import com.panhu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface Paymentservice {
    public int creat(Payment payment);
    public Payment getPaymentbyId(@Param("id") Long id);
}
