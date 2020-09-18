package com.ljx.controller;

import com.ljx.pojo.CommonResult;
import com.ljx.pojo.Payment;
import com.ljx.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李加喜
 * @date 2020/9/17 0017 7:21
 * @Email 1129071273@qq.com
 */
@RestController
@Slf4j
public class OpenFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/select/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
