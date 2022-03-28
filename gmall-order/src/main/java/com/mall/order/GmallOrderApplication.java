package com.mall.order;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableRabbit //基于注解的消息监听
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class GmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallOrderApplication.class, args);
    }

}
