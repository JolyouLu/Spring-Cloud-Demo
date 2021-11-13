package top.jolyoulu.simpleconsumerribbonuser8002.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.jolyoulu.simpleconsumerribbonuser8002.entity.User;

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
    private RestTemplate restTemplate;

    @GetMapping
    @ResponseBody
    public User test(){
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://SIMPLE-PROVIDER-USER/user", User.class);
        User body = responseEntity.getBody();
        log.info("收到消息 => {}",body);
        return body;
    }
}