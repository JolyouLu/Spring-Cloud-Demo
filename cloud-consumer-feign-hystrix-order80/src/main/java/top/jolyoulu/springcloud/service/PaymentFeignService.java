package top.jolyoulu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.jolyoulu.springcloud.entities.CommonResult;
import top.jolyoulu.springcloud.entities.Payment;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/21 0:21
 * @Version 1.0
 */
@Component
//使用fallback指定接口降级的回调
@FeignClient(name = "CLOUD-PAYMENT-SERVICE",
        fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String ok(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeOut/{id}")
    String timeOut(@PathVariable("id") Long id);
}
