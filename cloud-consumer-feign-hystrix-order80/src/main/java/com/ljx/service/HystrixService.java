package com.ljx.service;

import com.ljx.pojo.CommonResult;
import com.ljx.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 李加喜
 * @date 2020/9/17 0017 21:37
 * @Email 1129071273@qq.com
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = HystrixServiceImpl.class)
public interface HystrixService {
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getPaymentById(@PathVariable("id") Long id);
    @GetMapping("/payment/hystrix/error/{id}")
    public String paymentInfo_error(@PathVariable("id") Long id);
}
