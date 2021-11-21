package top.jolyoulu.springcloud.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import top.jolyoulu.myrule.MySelfRule;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 20:51
 * @Version 1.0
 */
@Configuration
//指定负载均衡策略,根据不同的服务使用不同的负载均衡策略
@RibbonClients({
    @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class),
    @RibbonClient(name = "CLOUD-PAYMENT-XXXX",configuration = MySelfRule.class),
})
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //开启Ribbon负载均衡，默认是轮询
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
