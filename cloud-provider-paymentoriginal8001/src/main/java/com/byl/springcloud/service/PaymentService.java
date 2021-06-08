package com.byl.springcloud.service;

import com.byl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PaymentService {
    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
