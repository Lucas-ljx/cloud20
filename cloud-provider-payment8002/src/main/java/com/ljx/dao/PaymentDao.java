package com.ljx.dao;

import com.ljx.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 李加喜
 * @date 2020/9/15 0015 15:54
 * @Email 1129071273@qq.com
 */
//@Mapper
public interface PaymentDao {
    /**
     * 写操作
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 读操作
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
