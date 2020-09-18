package com.ljx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 李加喜
 * @date 2020/9/15 0015 17:33
 * @Email 1129071273@qq.com
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_URL="http://cloud-providerConsul-payment8005";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getConsul")
    public String getzk(){
        String result=restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
}
