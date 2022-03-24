package com.mall.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * 自定义过滤器
 * <p>
 * 1.必须以GatewayFilterFactory为结尾，默认情况下过滤器的name会采用该自定义类的前缀这里的name=Custom
 * 2.在apply()方法中，同时包含pre和post过滤，在then方法中是请求结束后的处理方法
 * 3.CustomConfig是配置类，这个属性可以放在yml中使用
 *
 * @author wqi
 * @date 2022/3/18
 */
@Slf4j
//@Service
public class CustomLogGatewayFilterFactory extends
        AbstractGatewayFilterFactory<CustomLogGatewayFilterFactory.CustomConfig> {

    public CustomLogGatewayFilterFactory() {
        super(CustomConfig.class);
    }

    @Override
    public GatewayFilter apply(CustomConfig customConfig) {
        return ((exchange, chain) -> {
            log.info("前置处理[Pre] filter request,name:{}", customConfig.name);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("[Post] Response Filter! 后置处理");
            }));
        });
    }

    /**
     * 自定义过滤器的配置文件
     */
    public static class CustomConfig {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
