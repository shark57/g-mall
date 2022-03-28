package com.mall.order.config;

import com.mall.order.constant.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.Objects;


/**
 * rabbitMq配置相关信息
 *
 * @author wqi
 * @date 2020/04/29
 **/
@Slf4j
@Configuration
public class MqOrderConfig {

    //@Value("${rabbitMq.runMq:false}")
    private boolean runMq = false;

    @Resource
    private Environment env;

    @Resource
    private CachingConnectionFactory connectionFactory;

    /**
     * 使用JSON序列化机制，进行消息转换
     * @return
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 创建队列
     *
     * @return
     */
    @Bean(name = "orderSuccessQueue")
    public Queue orderSuccessQueue() {
        return new Queue(Objects.requireNonNull(env.getProperty(MqConstant.ORDER_SUCCESS_QUEUE)), true);
    }

    /**
     * 创建交换机
     *
     * @return
     */
    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(env.getProperty(MqConstant.ORDER_SUCCESS_EXCHANGE), true, false);
    }

    /**
     * 创建路由
     *
     * @return
     */
    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(orderSuccessQueue()).to(orderExchange())
                .with(env.getProperty(MqConstant.ORDER_SUCCESS_ROUTING_KEY));
    }

    /**
     * 创建消费者监听消费实例
     *
     * @return
     */
    @Bean(name = "simpleContainer")
    public SimpleMessageListenerContainer simpleContainer() {
        SimpleMessageListenerContainer simpleContainer = new SimpleMessageListenerContainer();
        simpleContainer.setConnectionFactory(connectionFactory);
        //设置手动确认模式
        simpleContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //设置监听队列
        simpleContainer.setQueueNames(env.getProperty(MqConstant.ORDER_SUCCESS_QUEUE));
        return simpleContainer;
    }

    /**
     * 判断项目是否需要启动时监听rabbitMQ
     * <p>
     * todo 该开关功能目前存在问题，尚未解决
     *
     * @param connectionFactory
     * @return
     */
    @Bean(name = "myRabbitListenerContainer")
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        //如果项目没有
        if (!runMq) {
            log.info("rabbitMq not auto start");
            //是否自动启动
            factory.setAutoStartup(false);
        }
        return factory;
    }
}
