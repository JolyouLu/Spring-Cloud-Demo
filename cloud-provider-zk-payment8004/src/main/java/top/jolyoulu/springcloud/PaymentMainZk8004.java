package top.jolyoulu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 0:02
 * @Version 1.0
 */
@SpringBootApplication
//使用consul或zookeeper作为注册中心是，使用该配置让当前服务向注册中心注册
@EnableDiscoveryClient
public class PaymentMainZk8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainZk8004.class, args);
    }
}
