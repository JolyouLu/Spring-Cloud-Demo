package top.jolyoulu.springcloud.alibaba.service;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 23:06
 * @Version 1.0
 */
public interface StorageService {
    void decrease(Long productId,Integer count);
}
