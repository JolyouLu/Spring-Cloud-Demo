package top.jolyoulu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.jolyoulu.springcloud.entities.CommonResult;
import top.jolyoulu.springcloud.entities.Payment;
import top.jolyoulu.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 20:47
 * @Version 1.0
 */
@Slf4j
@RestController
//Controller默认全局降级方法
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    //未指定降级方法使用全局的默认降级方法 paymentGlobalFallback()
    @HystrixCommand
    public String creat(@PathVariable("id") Long id){
        return paymentFeignService.ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
    //有指定的降级方法调用指定的
    @HystrixCommand(fallbackMethod = "getPaymentFallbackMethod",commandProperties = {
            //若该结果1500以内响应走正常执行，否则执行fallbackMethod中的方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String getPayment(@PathVariable("id") Long id){
        return paymentFeignService.timeOut(id);
    }
    public String getPaymentFallbackMethod(@PathVariable("id") Long id){
        return "消费者端触发了降级";
    }

    public String paymentGlobalFallback(){
        return "消费者触发了全局默认降级策略";
    }
}
