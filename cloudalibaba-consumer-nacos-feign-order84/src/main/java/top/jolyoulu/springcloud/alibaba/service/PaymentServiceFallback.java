package top.jolyoulu.springcloud.alibaba.service;

import org.springframework.stereotype.Component;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 15:34
 * @Version 1.0
 */
@Component
public class PaymentServiceFallback implements PaymentService{

    @Override
    public String nacos(Integer id) {
        return "发生异常/限流: " + id;
    }
}
