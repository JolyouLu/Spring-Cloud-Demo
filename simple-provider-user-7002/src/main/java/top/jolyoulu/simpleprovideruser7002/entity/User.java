package top.jolyoulu.simpleprovideruser7002.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: JolyouLu
 * @Date: 2021/11/13 16:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private Integer age;
    private String info;
}
