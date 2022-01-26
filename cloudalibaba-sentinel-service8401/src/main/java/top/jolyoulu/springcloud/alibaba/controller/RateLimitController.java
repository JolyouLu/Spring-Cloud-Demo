package top.jolyoulu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jolyoulu.springcloud.alibaba.handler.CustomerBlockHandler;
import top.jolyoulu.springcloud.entities.CommonResult;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 13:36
 * @Version 1.0
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", null);
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + " 服务不可用", null);
    }

    @GetMapping("/byResource/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,  //指定使用 CustomerBlockHandler 作为限流处理类
            blockHandler = "handlerException1") //使用CustomerBlockHandler.handlerException1 方法作为限流处理方法
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按资源名称限流测试OK", null);
    }

}
