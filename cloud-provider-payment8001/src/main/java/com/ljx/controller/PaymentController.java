package com.ljx.controller;

import com.ljx.pojo.CommonResult;
import com.ljx.pojo.Payment;
import com.ljx.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李加喜
 * @date 2020/9/15 0015 16:15
 * @Email 1129071273@qq.com
 */

/**
 * 前提是引入了lombok
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    /**
     * 获取项目的port
     */
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/insert")
    /**
     * 重点: 如果参数时放在请求体中，传入后台的话，那么后台要用@RequestBody才能接收到；如果不是放在
     *       请求体中的话，那么后台接收前台传过来的参数时，要用@RequestParam来接收，或则形参前
     *       什么也不写也能接收。
     *       这里接受的payment是存放在请求体中的数据
     */
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("插入结果"+i);
        if (i>0){
            return new CommonResult(200,"插入数据成功"+serverPort,i);
        }else{
            return new CommonResult(666,"对不起插入数据是被"+serverPort,null);
        }
    }
    @GetMapping("/select/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        log.info(id+"");
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            return new CommonResult(200,"查询数据成功"+serverPort,payment);
        }else{
            return new CommonResult(404,"查询数据失败"+serverPort,null);
        }
    }

//    自己测试能够显示什么信息
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String element:services){
            //获取当前eureka上面的服务
            log.info("***element"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    /**
     * ***elementcloud-payment-service
     * : ***elementcloud-order-service
     *  CLOUD-PAYMENT-SERVICE	172.17.226.28	8001	http://172.17.226.28:8001
     *  CLOUD-PAYMENT-SERVICE	172.17.226.28	8002	http://172.17.226.28:8002
     */
}
