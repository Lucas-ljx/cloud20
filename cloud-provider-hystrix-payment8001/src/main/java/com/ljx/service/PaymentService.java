package com.ljx.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author 李加喜
 * @date 2020/9/17 0017 18:26
 * @Email 1129071273@qq.com
 */
@Service
public class PaymentService {
//    ====>服务降级
    //正常访问
    public String paymentInfo_Ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"  paymentInfo_ok,id: "+id+"\t";
    }
    //如果超时了会执行哪一个方法

    /**
     * 双击shift HystrixCommandProperties里面查看要设置的具体的参数
     * 使其超时测试   在3秒内执行完成都是可以接受的,但是超过了3秒就会出现错误
     * 只要这个服务不可用自己跳转到兜底的服务里面
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(String id){
        int timeout=5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+" paymentInfo_error  id"+id+"\t"+"耗时:"+timeout;
    }

    public String paymentInfo_TimeOutHandle(String id){
        return "我是当出现异常的时候进行兜底的服务";
    }

    /**
     * ====>服务熔断
      * @return
     */
    /**
     * 测试的时候在在是10次请求里面一旦错误的请求超过了六次就会
     * 触发熔断在访问正确的也没有效果
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker( Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
