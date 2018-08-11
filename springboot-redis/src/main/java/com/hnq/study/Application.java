package com.hnq.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author henengqiang
 * @date 2018/8/11
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println("====================Application启动成功！====================");
    }

}
