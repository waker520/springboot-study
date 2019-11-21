package com.wangjc.bootlaunch.model.yaml;

import lombok.Data;

import java.util.List;

/**
 * description: Child <br>
 * date: 2019/11/18 14:03 <br>
 * author: 51337 <br>
 * version: 1.0 <br>
 */
@Data
public class Child {

    private String name;

    private Integer age;

    private List<Friend> friends;
}
