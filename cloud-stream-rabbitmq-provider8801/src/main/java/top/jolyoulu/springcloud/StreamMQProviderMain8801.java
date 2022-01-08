package top.jolyoulu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/8 17:54
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQProviderMain8801.class,args);
    }
}
