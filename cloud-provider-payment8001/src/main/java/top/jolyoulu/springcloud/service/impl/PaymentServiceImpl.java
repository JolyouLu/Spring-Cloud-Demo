package top.jolyoulu.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.jolyoulu.springcloud.dao.PaymentDao;
import top.jolyoulu.springcloud.entities.Payment;
import top.jolyoulu.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 12:11
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int creat(Payment payment) {
        return paymentDao.creat(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
