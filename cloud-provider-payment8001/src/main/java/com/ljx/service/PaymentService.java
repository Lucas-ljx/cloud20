package com.ljx.service;

import com.ljx.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 李加喜
 * @date 2020/9/15 0015 16:11
 * @Email 1129071273@qq.com
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
