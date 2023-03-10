package top.jolyoulu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: JolyouLu
 * @Date: 2021/12/19 19:21
 * @Version 1.0
 */
@RestController
@RefreshScope //刷新配置
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
