package com.ljx.service;

import com.ljx.pojo.CommonResult;
import com.ljx.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther 李加喜
 * @create
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService
{
    @GetMapping(value = "/select/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

//    @GetMapping(value = "/payment/feign/timeout")
//    public String paymentFeignTimeout();
}
