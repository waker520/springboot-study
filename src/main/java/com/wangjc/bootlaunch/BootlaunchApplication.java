package com.wangjc.bootlaunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})        //导入xml文件配置
public class BootlaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootlaunchApplication.class, args);
    }

}
