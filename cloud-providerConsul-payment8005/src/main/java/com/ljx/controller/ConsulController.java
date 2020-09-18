package com.ljx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 李加喜
 * @date 2020/9/16 0016 13:59
 * @Email 1129071273@qq.com
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class ConsulController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/consul")
    public String paymentzk(){
        return "springcloud consul :"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
