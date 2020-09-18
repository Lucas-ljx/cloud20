package com.murule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李加喜
 * @date 2020/9/16 0016 15:34
 * @Email 1129071273@qq.com
 */
@Configuration
public class MySelRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
        //定义为随机的
    }
    //默认是轮询的
}
