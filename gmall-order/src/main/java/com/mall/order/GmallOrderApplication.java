package com.mall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * todo 在使用seata的AT模式过程中，序列化和反序列化localdatetime类型字段报错
 * seata的新版本会自动实现数据源代理的装配，无需手动操作
 */
//@EnableRabbit //基于注解的消息监听
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class GmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallOrderApplication.class, args);
    }

}
