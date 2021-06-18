package com.byl.springcloud.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.byl.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;


public class CustomLimitConfig {
    public static String handlerException(BlockException e){
        return "=============================" +
                "=============================" +
                "handlerException-----is used.----------------";
//        return new CommonResult(4444, "全局GLOBAL的客户自定义处理---1",null);
    }

    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(4444, "全局GLOBAL的客户自定义处理----2",null);
    }

}
