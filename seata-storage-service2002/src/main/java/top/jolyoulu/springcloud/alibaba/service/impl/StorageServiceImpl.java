package top.jolyoulu.springcloud.alibaba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jolyoulu.springcloud.alibaba.dao.StorageDao;
import top.jolyoulu.springcloud.alibaba.service.StorageService;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 23:06
 * @Version 1.0
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----->StorageServiceImpl 扣库存开始");
        storageDao.decrease(productId,count);
    }
}
