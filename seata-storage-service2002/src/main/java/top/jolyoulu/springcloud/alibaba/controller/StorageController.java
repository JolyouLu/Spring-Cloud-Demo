package top.jolyoulu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jolyoulu.springcloud.alibaba.domain.CommonResult;
import top.jolyoulu.springcloud.alibaba.service.StorageService;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 23:08
 * @Version 1.0
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}
