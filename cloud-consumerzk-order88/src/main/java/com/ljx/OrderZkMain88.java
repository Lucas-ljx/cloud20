package com.ljx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 李加喜
 * @date 2020/9/16 0016 10:58
 * @Email 1129071273@qq.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain88 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain88.class,args);
    }
}
