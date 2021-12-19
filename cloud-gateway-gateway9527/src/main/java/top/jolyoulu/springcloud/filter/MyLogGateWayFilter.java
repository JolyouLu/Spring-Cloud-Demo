package top.jolyoulu.springcloud.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author: JolyouLu
 * @Date: 2021/12/19 14:25
 * @Version 1.0
 */
@Slf4j
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*****************come in MyLogGateWayFilter："+new Date());
        //从请求参数中获取uname
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null){
            log.error("用户名未null，非法用户");
            //设置状态码，请求不被接受
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //过滤器排序，越小优先级越高
        return 0;
    }
}
