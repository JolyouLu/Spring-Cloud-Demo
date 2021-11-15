package top.jolyoulu.simplefeignuserapi.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.jolyoulu.simplefeignuserapi.entity.User;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/15 15:08
 * @Version 1.0
 */
@FeignClient(name = "simple-provider-user",path = "/user")
public interface UserApi {

    @RequestMapping(method = RequestMethod.GET, value = "")
    User getUser();

}
