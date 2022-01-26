package top.jolyoulu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.jolyoulu.springcloud.entities.CommonResult;

import javax.annotation.Resource;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/15 18:52
 * @Version 1.0
 */
@Slf4j
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    //从配置文件获取服务url
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",         //fallback只处理接口异常
            exceptionsToIgnore = {IllegalArgumentException.class}, //指定异常不执行fallback方法
            blockHandler = "handlerBlockHandler") //blockHandler只处理接口流控
    public String paymentInfo(@PathVariable("id") Integer id) {
        //当id是5时，抛异常，非法参数异常
        if (id == 5) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        }
        //当id>10时，抛异常，空指针异常
        if (id > 10) {
            throw new NullPointerException("NullPointerException 空指针异常");
        }
        //发起请求
        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
    }
    public String handlerFallback(@PathVariable("id") Integer id, Throwable e) {
        return "发生异常: " + e.getMessage();
    }
    public String handlerBlockHandler(@PathVariable("id") Integer id, BlockException e) {
        return "发生流控: " + e.getMessage();
    }

}
