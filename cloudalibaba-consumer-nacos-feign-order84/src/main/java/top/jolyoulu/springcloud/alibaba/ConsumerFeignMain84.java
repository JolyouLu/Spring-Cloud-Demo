package top.jolyoulu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/15 15:24
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignMain84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignMain84.class,args);
    }
}
