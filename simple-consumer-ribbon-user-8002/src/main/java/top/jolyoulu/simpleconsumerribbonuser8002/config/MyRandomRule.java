package top.jolyoulu.simpleconsumerribbonuser8002.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/15 13:52
 * @Version 1.0
 * 自定义负载均衡策略，每个服务访问5次，跟换下一个服务
 */
public class MyRandomRule extends AbstractLoadBalancerRule {
    private int total = 0; //当前服务的服务的总次数
    private int currentIndex = 0;  //当前提供服务的服务下标

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers(); //获取存活的服务
            List<Server> allList = lb.getAllServers(); //获取全部服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            //自定义负载均衡=============================
            if(total < 5){
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()){
                    currentIndex = 0;
                }
                server = upList.get(currentIndex);
            }
            //自定义负载均衡=============================

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
