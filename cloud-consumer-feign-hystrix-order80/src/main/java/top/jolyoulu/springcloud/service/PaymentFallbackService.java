package top.jolyoulu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: JolyouLu
 * @Date: 2021/12/16 18:16
 * @Version 1.0
 * 实现PaymentFeignService，当PaymentFeignService中有接口被降级会
 * 调用该类下对应的方法实现
 */
@Component
public class PaymentFallbackService implements PaymentFeignService{
    @Override
    public String ok(Long id) {
        return "PaymentFallbackService ok fallback";
    }

    @Override
    public String timeOut(Long id) {
        return "PaymentFallbackService timeOut fallback";
    }
}
