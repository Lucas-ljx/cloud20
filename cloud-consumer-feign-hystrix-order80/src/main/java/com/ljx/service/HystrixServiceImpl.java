package com.ljx.service;

import org.springframework.stereotype.Component;

/**
 * @author 李加喜
 * @date 2020/9/17 0017 23:33
 * @Email 1129071273@qq.com
 */
@Component
public class HystrixServiceImpl implements HystrixService {
    @Override
    public String getPaymentById(Long id) {
        return "我是getPaymentById方法的指定的兜底方法";
    }

    @Override
    public String paymentInfo_error(Long id) {
        return "我是paymentInfo_error方法的指定的兜底方法";
    }
}
