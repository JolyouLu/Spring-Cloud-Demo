package top.jolyoulu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/24 21:46
 * @Version 1.0
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "testB";
    }

    @GetMapping("/testRT")
    public String testRT(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "测试降级规则 RT";
    }

    @GetMapping("/testTO")
    public String testTO(){
        int age = 10 / 0;
        return "测试降级规则 异常";
    }

    @GetMapping("/testHotKey")
    //配置热点规则的接口必须使用@SentinelResource
    //value 对应热点规则的 资源名
    //blockHandler 定义一个处理限流的方法（如果不定义触发限流时前端会收到500保存页面，不友好）
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey";
    }
}
