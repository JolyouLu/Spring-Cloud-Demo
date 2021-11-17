package top.jolyoulu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.jolyoulu.springcloud.entities.CommonResult;
import top.jolyoulu.springcloud.entities.Payment;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/16 20:47
 * @Version 1.0
 */
@Slf4j
@RestController
public class OrderController {
    //与Eureka不同之处，服务名在consul中是小写的
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> creat(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/discovery")
    public Object discovery(){
        //获取所有注册到consul的实例
        log.info("获取所有注册到Zk的实例");
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }

        //通过微服务名称获取详细的微服务详细
        log.info("cloud-payment-service 服务名称中所有实例详细信息");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }

}
