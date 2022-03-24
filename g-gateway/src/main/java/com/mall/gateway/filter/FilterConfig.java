package com.mall.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器
 * 实现 GlobalFilter 和 Ordered，重写相关方法，加入到spring容器管理即可，无需配置，全局过滤器对所有的路由都有效
 * <p>
 * Spring-Cloud-Gateway 基于过滤器实现，同zuul类似，有pre和post两种方式的filter,分别处理前置逻辑和后置逻辑。
 * 客户端的请求先经过pre类型的filter，然后将请求转发到具体的业务服务，收到业务服务的响应之后，再经过post类型的 filter 处理，
 * 最后返回响应到客户端。过滤器执行流程如下，order越大，优先级越低
 *
 * @author wqi
 * @date 2021/7/29
 */
//@Configuration
public class FilterConfig {

    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return new AFilter();
    }

    @Bean
    @Order(0)
    public GlobalFilter b() {
        return new BFilter();
    }

    @Bean
    @Order(1)
    public GlobalFilter c() {
        return new CFilter();
    }


    @Slf4j
    public static class AFilter implements GlobalFilter, Ordered {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("AFilter前置逻辑");
            exchange.getRequest().getCookies();
            return chain.filter(exchange).then(Mono.fromRunnable(() ->
            {
                log.info("AFilter后置逻辑");
            }));
        }

        //   值越小，优先级越高
        int HIGHEST_PRECEDENCE = -2147483648;
        int LOWEST_PRECEDENCE = 2147483647;

        @Override
        public int getOrder() {
            return HIGHEST_PRECEDENCE + 100;
        }
    }

    @Slf4j
    public static class BFilter implements GlobalFilter, Ordered {
        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("BFilter前置逻辑");
            return chain.filter(exchange).then(Mono.fromRunnable(() ->
            {
                log.info("BFilter后置逻辑");
            }));
        }


        //   值越小，优先级越高
        int HIGHEST_PRECEDENCE = -2147483648;
        int LOWEST_PRECEDENCE = 2147483647;

        @Override
        public int getOrder() {
            return HIGHEST_PRECEDENCE + 200;
        }
    }

    @Slf4j
    public static class CFilter implements GlobalFilter, Ordered {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("CFilter前置逻辑");
            return chain.filter(exchange).then(Mono.fromRunnable(() ->
            {
                log.info("CFilter后置逻辑");
            }));
        }

        //   值越小，优先级越高
        int HIGHEST_PRECEDENCE = -2147483648;
        int LOWEST_PRECEDENCE = 2147483647;

        @Override
        public int getOrder() {
            return HIGHEST_PRECEDENCE + 300;
        }
    }
}
