package com.ljx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 李加喜
 * @date 2020/9/16 0016 10:22
 * @Email 1129071273@qq.com
 */
@SpringBootApplication
@EnableDiscoveryClient
/**
 * 这个注解用于向使用consul
 * 或者zookeeper作为注册中心时注册服务
 */
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
