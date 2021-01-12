package com.panhu.springcloud.dao;




import com.panhu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    public int creat(Payment payment);
    public Payment getPaymentbyId(@Param("id") Long id);
}
