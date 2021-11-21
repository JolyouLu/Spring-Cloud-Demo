package top.jolyoulu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/20 18:46
 * @Version 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRile(){
        return new RandomRule(); //定义随机负载均衡策略
    }
}
