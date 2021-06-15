package com.byl.springcloud.controller;

import com.byl.springcloud.service.IMessageProvider;
import com.byl.springcloud.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {
    @Resource
    public IMessageProvider iMessageProvider;

    @GetMapping("/messagesend")
    public String send() {
        return iMessageProvider.send();
    }
}
