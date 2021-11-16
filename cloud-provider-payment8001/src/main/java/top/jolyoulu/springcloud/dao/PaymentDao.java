package top.jolyoulu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.jolyoulu.springcloud.entities.Payment;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 11:37
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    int creat(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
