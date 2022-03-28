package com.mall.ware.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wqi
 * @date 2022/3/28
 */
@Configuration
public class MqWareConfig {

    /**
     * 使用JSON序列化机制，进行消息转换
     * <p>
     * Jackson2JsonMessageConverter，是rabbitmq对java对象json序列化的支持，在发送消息时，
     * 会先将自定义的消息类序列化成json格式，再转成byte构造Message，rabbitmq的ack就被设置为自动提交
     *
     * @return
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
