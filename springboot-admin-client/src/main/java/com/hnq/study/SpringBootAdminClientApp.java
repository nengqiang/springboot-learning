package com.hnq.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author henengqiang
 * @date 2019/05/15
 */
@Configuration
@EnableAutoConfiguration
@Slf4j
public class SpringBootAdminClientApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClientApp.class);
        log.info(">>> SpringBootAdminClientApp Start Success!");
    }

}
