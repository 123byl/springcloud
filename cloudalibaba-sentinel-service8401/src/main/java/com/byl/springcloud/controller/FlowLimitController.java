package com.byl.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.byl.springcloud.config.CustomLimitConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {
    @GetMapping("/sentinel/getA")
    public String getA() {
        return "===========getA============";
    }

    @GetMapping("/sentinel/getB")
    public String getB() {
        return "===========getB============";
    }

    @GetMapping("/testhotkey")
    @SentinelResource(value = "testhotkey001",blockHandler = "hotKeyHandler")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "==========testHotKey===============";

    }

    public String hotKeyHandler(String p1, String p2, BlockException e) {
        return "============hotKeyHandler=============";
    }

    @GetMapping("/byurl")
    @SentinelResource(value = "byurl",blockHandler = "urlHandler")
    public String testUrl(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "==========url test success===============";

    }

    public String urlHandler(String p1, String p2, BlockException e) {
        return "============hotKeyHandler============="+e.getMessage()+"============hotKeyHandler=============";
    }
    //自定义处理器 放到一个类里  实现代码和业务分离
    @GetMapping("/testcoustom")
    @SentinelResource(value = "testcoustom",blockHandlerClass = CustomLimitConfig.class,blockHandler = "handlerException")
    public String testCoustom() {
        return "==========testCoustom success===============";
    }

}
