package com.mall.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 后置自定义拦截器
 * <p>
 * 自定义类的后缀一定以
 * GatewayFilterFactory{@link org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory}
 * 为结尾
 *
 * @author wqi
 * @date 2022/3/19
 */
@Component
public class CustomPostGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomPostGatewayFilterFactory.Config> {

    public CustomPostGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // grab configuration from Config object
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                //Manipulate the response in some way
            }));
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }

}
