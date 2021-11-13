package top.jolyoulu.simpleeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class SimpleEurekaServer9000Application {

    public static void main(String[] args) {
        SpringApplication.run(SimpleEurekaServer9000Application.class, args);
    }

}
