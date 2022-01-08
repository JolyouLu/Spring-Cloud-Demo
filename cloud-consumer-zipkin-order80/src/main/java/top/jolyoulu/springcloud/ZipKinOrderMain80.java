package top.jolyoulu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 20:44
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ZipKinOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZipKinOrderMain80.class, args);
    }
}
