package top.jolyoulu.simpleconsumerribbonuser8002.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/13 16:34
 * @Version 1.0
 */
@Configuration
public class MyConfig {

    //Ribbon使用负载均衡，默认策略(轮询)
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //修改Ribbon负载均衡测率
    @Bean
    public IRule myRule(){
//        return new RandomRule(); //使用随机测量
        return new MyRandomRule(); //使用自定义负载均衡
    }



}
