package top.jolyoulu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 12:15
 * @Version 1.0
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPost;

    @GetMapping(value = "/payment/nacos/{id}")
    public String create(@PathVariable("id") Integer id){
        return "服务提供者，serverPort："+serverPost+" id"+id;
    }

}
