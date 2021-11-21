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
//该Service是向那个服务提供者发送请求的
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //服务提供者的URL
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);

    //服务提供者的URL
    @GetMapping("/payment/create")
    CommonResult<Payment> creat(Payment payment);
}
