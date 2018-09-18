package com.hnq.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
@SpringBootApplication
@ImportResource(value = {"classpath:spring/appContext.xml"})
public class ViewApplication {

    private static final Logger logger = LoggerFactory.getLogger(ViewApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ViewApplication.class);
        logger.info("==========>> ViewApplication Start Success!");
    }

}
