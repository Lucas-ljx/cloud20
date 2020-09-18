package com.ljx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 李加喜
 * @date 2020/9/16 0016 11:01
 * @Email 1129071273@qq.com
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderZkController {

    public static final String INVOKE_URL="http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getzk")
    public String getzk(){
        String result=restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return result;
    }
}
