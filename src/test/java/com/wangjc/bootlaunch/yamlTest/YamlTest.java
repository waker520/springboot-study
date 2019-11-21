package com.wangjc.bootlaunch.yamlTest;

import com.wangjc.bootlaunch.model.yaml.Family;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * description: YamlTest <br>
 * date: 2019/11/18 14:25 <br>
 * author: 51337 <br>
 * version: 1.0 <br>
 */
@SpringBootTest
public class YamlTest {

    @Autowired
    Family family;

    @Test
    public void testYaml(){
        System.out.println(family.toString());
    }

}
