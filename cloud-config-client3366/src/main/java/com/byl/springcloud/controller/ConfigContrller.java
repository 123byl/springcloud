package com.byl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigContrller {
    @Value("${server.port}")
    public String serverPort;
    @Value("${config.info}")
    public String configinfo;

    @RequestMapping("/configinfo")
    public String getConfiginfo() {
        return serverPort+configinfo;
    }
}
