package top.jolyoulu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/20 19:37
 * @Version 1.0
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstance);
}
