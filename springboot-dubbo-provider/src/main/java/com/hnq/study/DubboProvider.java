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
@ImportResource(value = {"classpath:spring/providerContext.xml"})
public class DubboProvider {

    private static final Logger logger = LoggerFactory.getLogger(DubboProvider.class);

    public static void main(String[] args) {
        SpringApplication.run(DubboProvider.class, args);
        logger.info("===============DubboProvider启动成功！===============");
    }

}
