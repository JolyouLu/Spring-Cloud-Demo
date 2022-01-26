package top.jolyoulu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.jolyoulu.springcloud.alibaba.domain.CommonResult;

import java.math.BigDecimal;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 21:51
 * @Version 1.0
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money);

}
