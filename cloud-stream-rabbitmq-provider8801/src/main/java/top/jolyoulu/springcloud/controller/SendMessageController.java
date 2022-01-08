package top.jolyoulu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jolyoulu.springcloud.service.IMessageProvider;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/8 18:04
 * @Version 1.0
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
