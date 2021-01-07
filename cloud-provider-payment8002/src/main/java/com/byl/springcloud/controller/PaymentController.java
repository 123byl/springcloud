package com.byl.springcloud.controller;

import com.byl.springcloud.entities.CommonResult;
import com.byl.springcloud.entities.Payment;
import com.byl.springcloud.service.PaymentService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    public PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/add")
    public CommonResult add(@RequestBody Payment payment) {
        int result= paymentService.add(payment);
        log.info("payment");
        log.info("hello");
        System.out.println("插入结果"+result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,serverPort"+serverPort, result);
        }else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("查询结果"+payment.toString());
        if (payment!=null) {
            return new CommonResult(200, "查询成功,serverPort"+serverPort, payment);
        }else {
            return new CommonResult(444, "查询失败", null);
        }
    }
}
