package top.jolyoulu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import top.jolyoulu.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 12:11
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String ok(Long id) {
        //该方法能够正常返回消息
        return "线程池："+Thread.currentThread().getName()+" ok，id："+id;
    }


    @Override
    //使用Hystrix对该方法进行降级
    @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties = {
            //若该结果3000以内响应走正常执行，否则执行fallbackMethod中的方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String timeOut(Long id) {
        //让线程休息3秒，导致该接口请求时会超时
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池："+Thread.currentThread().getName()+" timeOut，id："+id;
    }

    public String timeOutHandler(Long id) {
        return "线程池："+Thread.currentThread().getName()+" timeOutHandler，id："+id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "circuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少启动
    })
    public String circuitBreaker(Integer id){
        if (id < 0 ){
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String circuitBreakerFallback(Integer id){
        return "id 不能负数，请稍后再试 id："+id;
    }
}
