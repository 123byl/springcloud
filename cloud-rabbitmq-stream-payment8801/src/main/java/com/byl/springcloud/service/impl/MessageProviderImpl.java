package com.byl.springcloud.service.impl;

import com.byl.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    public MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> message = MessageBuilder.withPayload(serial).build();
        output.send(message);


        return null;
    }
}
