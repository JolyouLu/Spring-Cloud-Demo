package top.jolyoulu.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 23:20
 * @Version 1.0
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
