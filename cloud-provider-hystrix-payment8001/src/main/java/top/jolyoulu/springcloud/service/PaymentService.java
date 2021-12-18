package top.jolyoulu.springcloud.service;


/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 12:10
 * @Version 1.0
 */
public interface PaymentService {

    String ok(Long id);

    String timeOut(Long id);

    String circuitBreaker(Integer id);
}
