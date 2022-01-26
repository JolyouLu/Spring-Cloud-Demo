package top.jolyoulu.springcloud.alibaba.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jolyoulu.springcloud.alibaba.dao.OrderDao;
import top.jolyoulu.springcloud.alibaba.domain.Order;
import top.jolyoulu.springcloud.alibaba.service.AccountService;
import top.jolyoulu.springcloud.alibaba.service.OrderService;
import top.jolyoulu.springcloud.alibaba.service.StorageService;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 21:52
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @Override
    //开启分布式事务，name随便定义，rollbackFor触发什么异常回滚
    @GlobalTransactional(name = "test-creat-order",rollbackFor = Exception.class)
    public void creat(Order order) {
        log.info("----->开始新建订单");
        orderDao.creat(order);
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        //修改订单状态
        log.info("----->开始修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("----->下单结束");
    }
}
