package top.jolyoulu.simpleconsumerfeignuser8003.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.jolyoulu.simplefeignuserapi.api.UserApi;
import top.jolyoulu.simplefeignuserapi.entity.User;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/13 16:38
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserApi userApi;

    @GetMapping
    @ResponseBody
    public User test(){
        User user = userApi.getUser();
        log.info("收到消息 => {}",user);
        return user;
    }
}