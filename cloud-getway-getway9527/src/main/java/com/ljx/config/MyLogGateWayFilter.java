package com.ljx.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author 李加喜
 * @date 2020/9/18 0018 13:48
 * @Email 1129071273@qq.com
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    /**
     * 总的全局过滤器
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("欢迎来到全局过滤器"+new Date());
        String uname=exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname==null){
            log.info("对不起非法用户,不可进入");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //返回错误的原因
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
