package top.jolyoulu.springcloud.service;

import org.apache.ibatis.annotations.Param;
import top.jolyoulu.springcloud.entities.Payment;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 12:10
 * @Version 1.0
 */
public interface PaymentService {
    int creat(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
