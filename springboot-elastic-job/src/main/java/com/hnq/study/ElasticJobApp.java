package com.hnq.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author henengqiang
 * @date 2019/07/17
 */
@SpringBootApplication
@ImportResource(locations = "classpath:spring/appContext.xml")
public class ElasticJobApp {

    public static void main(String[] args) {
        SpringApplication.run(ElasticJobApp.class);
        System.out.println(">>> ElasticJobApp Start Success!");
    }

}
