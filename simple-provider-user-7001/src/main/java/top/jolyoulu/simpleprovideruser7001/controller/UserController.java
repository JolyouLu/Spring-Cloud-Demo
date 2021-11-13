package top.jolyoulu.simpleprovideruser7001.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.jolyoulu.simpleprovideruser7001.entity.User;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/13 16:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @ResponseBody
    public User test(){
        return new User("001","张三",22,"消息来自simple-provider-user-7001");
    }
}
