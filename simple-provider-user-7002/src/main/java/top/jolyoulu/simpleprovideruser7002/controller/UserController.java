package top.jolyoulu.simpleprovideruser7002.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.jolyoulu.simpleprovideruser7002.entity.User;

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
        return new User("002","李四",33,"消息来自simple-provider-user-7002");
    }
}
