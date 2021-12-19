package top.jolyoulu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: JolyouLu
 * @Date: 2021/12/18 16:51
 * @Version 1.0
 * 使用编码方式配置类路由
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //将 http://localhost:9527/guonei 路由到 http://news.baidu.com/guonei
        routes.route("path_route_guonei",r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei"))
                .build();

        //将 http://localhost:9527/guoji 路由到 http://news.baidu.com/guoji
        routes.route("path_route_guoji",r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }

}
