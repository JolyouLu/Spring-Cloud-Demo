package top.jolyoulu.simplefeignuserapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/13 16:38
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private Integer age;
    private String info;

}
