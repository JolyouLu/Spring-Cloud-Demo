package top.jolyoulu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jolyoulu.springcloud.alibaba.dao.AccountDao;
import top.jolyoulu.springcloud.alibaba.domain.CommonResult;
import top.jolyoulu.springcloud.alibaba.service.AccountService;

import java.math.BigDecimal;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 23:22
 * @Version 1.0
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功");
    }
}
