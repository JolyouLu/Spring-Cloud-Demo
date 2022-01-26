package top.jolyoulu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.jolyoulu.springcloud.alibaba.domain.Order;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 21:37
 * @Version 1.0
 */
@Mapper
public interface OrderDao {

    //创建订单
    void creat(Order order);

    //修改订单状态，从零改1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
