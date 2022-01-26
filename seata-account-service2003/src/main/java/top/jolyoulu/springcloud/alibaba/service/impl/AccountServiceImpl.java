package top.jolyoulu.springcloud.alibaba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jolyoulu.springcloud.alibaba.dao.AccountDao;
import top.jolyoulu.springcloud.alibaba.service.AccountService;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 23:21
 * @Version 1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----->AccountServiceImpl扣减账户余额开始");
//        try {
//            TimeUnit.SECONDS.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId,money);
    }
}
