package com.mall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author wqi
 * @date 2022/3/27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GmallWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallWareApplication.class, args);
    }

}
