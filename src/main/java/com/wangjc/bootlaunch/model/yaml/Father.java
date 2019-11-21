package com.wangjc.bootlaunch.model.yaml;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * description: Father <br>
 * date: 2019/11/18 14:03 <br>
 * author: 51337 <br>
 * version: 1.0 <br>
 */
@Data
public class Father {

    private String name;

    @Min(20)
    private Integer age;
}
