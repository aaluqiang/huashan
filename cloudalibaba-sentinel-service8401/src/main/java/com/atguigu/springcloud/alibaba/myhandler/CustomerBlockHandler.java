package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;

public class CustomerBlockHandler {


    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(44444,"按客户自定义,global handlerException--------1");
    }

    public static CommonResult handlerException2(BlockException exception){
    return new CommonResult(44444,"按客户自定义,global handlerException--------2");
}

}
