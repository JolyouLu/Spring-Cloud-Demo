package top.jolyoulu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 20:44
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainZk80.class, args);
    }
}
