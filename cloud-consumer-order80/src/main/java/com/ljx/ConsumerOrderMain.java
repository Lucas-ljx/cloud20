package com.ljx;

import com.murule.MySelRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 李加喜
 * @date 2020/9/15 0015 17:29
 * @Email 1129071273@qq.com
 */
@SpringBootApplication
@RibbonClient(value = "CLOUD-ORDER-SERVICE",configuration = MySelRule.class)
public class ConsumerOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain.class,args);
    }
}
