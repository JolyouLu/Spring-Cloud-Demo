package top.jolyoulu.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import top.jolyoulu.springcloud.entities.CommonResult;

/**
 * @Author: JolyouLu
 * @Date: 2022/1/26 14:15
 * @Version 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException blockException) {
        return new CommonResult(411, "全局了限流处理方法 CustomerBlockHandler.handlerException1()", null);
    }


    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(422, "全局了限流处理方法 CustomerBlockHandler.handlerException2()", null);
    }

}
