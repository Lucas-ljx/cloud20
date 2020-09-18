package com.ljx.controller;

import com.ljx.pojo.CommonResult;
import com.ljx.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 李加喜
 * @date 2020/9/15 0015 17:33
 * @Email 1129071273@qq.com
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 传递给后面数据的时候 数据被存放子请求体里面所以要后台要使用@RequestBody来接受数据
     * @param payment
     * @return
     */
    @PostMapping("/insert")
    public CommonResult<Payment> create(Payment payment){
        //读用get 写用post   插入值是payment 返回值是CommonResult
        return restTemplate.postForObject(PAYMENT_URL+"/insert",payment, CommonResult.class);
    }
    @GetMapping("/select/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/select/"+id, CommonResult.class);
    }

    /**
     * 如果想要获取更加详细的信息就使用Entity如果想要获取一个字符换Object
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/select/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }

    }
}
