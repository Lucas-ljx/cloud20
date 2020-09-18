package com.ljx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 李加喜
 * @date 2020/9/17 0017 21:35
 * @Email 1129071273@qq.com
 */
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
public class OpenFeignHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignHystrixMain.class,args);
    }
}
