package com.ljx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 李加喜
 * @date 2020/9/17 0017 7:06
 * @Email 1129071273@qq.com
 */
@SpringBootApplication
@EnableFeignClients
/**
 * @EnableFeignClients使用Feign激活并开启
 */
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
