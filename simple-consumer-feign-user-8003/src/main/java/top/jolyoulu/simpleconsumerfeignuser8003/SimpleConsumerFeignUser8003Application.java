package top.jolyoulu.simpleconsumerfeignuser8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "top.jolyoulu.simplefeignuserapi")
@EnableDiscoveryClient
public class SimpleConsumerFeignUser8003Application {

    public static void main(String[] args) {
        SpringApplication.run(SimpleConsumerFeignUser8003Application.class, args);
    }

}
