package com.hnq.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author henengqiang
 * @date 2018/8/10
 */
@SpringBootApplication
@MapperScan(basePackages = "com.hnq.study.dao.mapper")
@ImportResource(value = {"classpath:spring/appContext.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println("====================Application启动成功！====================");
    }

}
