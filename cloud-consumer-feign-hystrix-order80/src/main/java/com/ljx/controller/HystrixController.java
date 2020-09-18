package com.ljx.controller;

import com.ljx.pojo.CommonResult;
import com.ljx.pojo.Payment;
import com.ljx.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 李加喜
 * @date 2020/9/17 0017 21:36
 * @Email 1129071273@qq.com
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class HystrixController {
    @Resource
    private HystrixService hystrixService;

    @GetMapping("/consumer/select/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id)
    {
        String result = hystrixService.getPaymentById(id);
        return result;
    }

    @GetMapping("/consumer/error/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Long id)
    {
//        int age = 10/0;
        String result = hystrixService.paymentInfo_error(id);
        return result;
    }
//    public String paymentTimeOutFallbackMethod()
//    {
//        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
//    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
