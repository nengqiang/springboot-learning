package com.hnq.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author henengqiang
 * @date 2018/9/20
 */
@SpringBootApplication
@MapperScan(value = {"com.hnq.study.dao.mapper"})
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class);
        System.out.println(" ==========>> ShiroApplication Start Success! ");
    }

}
