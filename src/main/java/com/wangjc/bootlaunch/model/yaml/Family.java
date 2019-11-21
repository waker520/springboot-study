package com.wangjc.bootlaunch.model.yaml;

import com.wangjc.bootlaunch.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * description: Family <br>
 * date: 2019/11/18 14:03 <br>
 * author: 51337 <br>
 * version: 1.0 <br>
 */
@Data
@Component
@Validated      //属性校验
@ConfigurationProperties(prefix = "family")     //根据前缀将YML中配置的自定义属性加载，支持松散语法，支持复杂对象，支持JSR303数据校验
@PropertySource(value ={"classpath:family.yml"},factory = MixPropertySourceFactory.class)       //从自定义配置文件中加载注入
public class Family {

    //@Value("${family.family-name}")   //指定单个属性注入，支持spEL
    @NotEmpty
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;
}
