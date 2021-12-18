package top.jolyoulu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.jolyoulu.springcloud.entities.CommonResult;
import top.jolyoulu.springcloud.entities.Payment;
import top.jolyoulu.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 12:15
 * @Version 1.0
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPost;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Long id){
        return paymentService.ok(id);
    }

    @GetMapping(value = "/payment/hystrix/timeOut/{id}")
    public String timeOut(@PathVariable("id") Long id){
        return paymentService.timeOut(id);
    }

    @GetMapping(value = "/payment/hystrix/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){
        return paymentService.circuitBreaker(id);
    }


}
