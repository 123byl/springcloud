package com.byl.springcloud.controller;

import com.byl.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){

        String result = paymentHystrixService.paymentInfo_OK(id);

        return result;
    }



    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_Timeout(id);

        return result;
    }

    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙，请10秒后再试，o(╥﹏╥)o";
    }

    public String payment_Global_FallbackMethod() {
        return "this is global fallback.";
    }
}
