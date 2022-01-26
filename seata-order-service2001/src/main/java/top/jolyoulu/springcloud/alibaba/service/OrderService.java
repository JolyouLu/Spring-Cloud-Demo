package top.jolyoulu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import top.jolyoulu.springcloud.alibaba.domain.Order;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 21:51
 * @Version 1.0
 */
public interface OrderService {

    void creat(Order order);
}
