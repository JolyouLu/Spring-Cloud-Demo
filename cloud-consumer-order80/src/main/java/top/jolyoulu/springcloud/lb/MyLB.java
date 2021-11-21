package top.jolyoulu.springcloud.lb;

import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/20 19:38
 * @Version 1.0
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstance) {
        int index = getAndIncrement() % serviceInstance.size();
        return serviceInstance.get(index);
    }

    /**
     * CAS 自增
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        //CAS，比较替换，自旋到+1成功为止
        do {
            current = this.atomicInteger.get(); //获取当前int值
            next = current >= Integer.MAX_VALUE ? 0 : current + 1; //判断是否是int最大值，不是则++
        }while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }
}
