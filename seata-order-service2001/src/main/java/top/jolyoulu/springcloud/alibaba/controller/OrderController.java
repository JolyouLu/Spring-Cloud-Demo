package top.jolyoulu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jolyoulu.springcloud.alibaba.domain.CommonResult;
import top.jolyoulu.springcloud.alibaba.domain.Order;
import top.jolyoulu.springcloud.alibaba.service.OrderService;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 22:07
 * @Version 1.0
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/creat")
    public CommonResult creat(Order order){
        orderService.creat(order);
        return new CommonResult(200,"订单创建成功");
    }

}
