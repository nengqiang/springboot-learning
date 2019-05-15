package com.hnq.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author henengqiang
 * @date 2019/05/15
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@Slf4j
public class SpringBootAdminServerApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminServerApp.class);
        log.info(">>> SpringBootAdminServerApp Start Success!");
    }

}
