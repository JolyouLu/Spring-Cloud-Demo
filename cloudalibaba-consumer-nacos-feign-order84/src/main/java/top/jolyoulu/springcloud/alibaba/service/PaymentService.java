package top.jolyoulu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 15:30
 * @Version 1.0
 */
@FeignClient(value = "nacos-payment-provider",
        //熔断/限流的处理类
        fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping(value = "/payment/nacos/{id}")
    public String nacos(@PathVariable("id") Integer id);

}
