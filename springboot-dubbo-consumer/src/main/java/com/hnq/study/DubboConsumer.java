package com.hnq.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author henengqiang
 * @date 2018/8/14
 */
@SpringBootApplication
@ImportResource(value = {"classpath:spring/consumerContext.xml"})
public class DubboConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DubboConsumer.class);

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumer.class);
        logger.info("===============DubboConsumer启动成功！===============");
    }

}
