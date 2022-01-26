package top.jolyoulu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.jolyoulu.springcloud.alibaba.service.PaymentService;

import javax.annotation.Resource;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/15 18:52
 * @Version 1.0
 */
@Slf4j
@RestController
public class OrderNacosController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return paymentService.nacos(id);
    }
}
