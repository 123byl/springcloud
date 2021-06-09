package com.byl.springcloud.service.impl;

import com.byl.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceFallbackImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixServiceFallbackImpl---paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentHystrixServiceFallbackImpl---paymentInfo_Timeout";
    }
}
