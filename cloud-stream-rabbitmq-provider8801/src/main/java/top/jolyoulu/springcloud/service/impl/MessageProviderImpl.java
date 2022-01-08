package top.jolyoulu.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import top.jolyoulu.springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/8 17:57
 * @Version 1.0
 */
@EnableBinding(Source.class) //定义消息推送的管道
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        //使用消息构建器构建消息
        Message<String> message = MessageBuilder.withPayload(serial).build();
        //发送消息
        output.send(message);
        return null;
    }
}
