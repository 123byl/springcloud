package com.byl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    public String serverPort;
    @StreamListener(Sink.INPUT)
    public void receive(Message<String>message) {
        String payload = message.getPayload();

        System.out.println(payload+serverPort);

    }

}
