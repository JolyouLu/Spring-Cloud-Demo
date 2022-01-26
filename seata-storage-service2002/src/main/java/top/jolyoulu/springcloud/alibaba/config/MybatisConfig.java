package top.jolyoulu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 22:09
 * @Version 1.0
 */
@Configuration
@MapperScan({"top.jolyoulu.springcloud.alibaba.dao"})
public class MybatisConfig {

    

}
