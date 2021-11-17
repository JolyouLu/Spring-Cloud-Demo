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

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        log.info("插入结果："+result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功,serverPost: "+serverPost,result);
        }else {
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverPost: "+serverPost,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id);
        }
    }
}
