package com.mall.order.mq.provider;

import com.mall.common.entity.order.OmsOrderMsg;
import com.mall.order.constant.MqConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wqi
 * @date 2022/3/28
 */
@Service
@Slf4j
public class OrderProvider {

    @Resource
    private Environment env;

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送指信息至mq队列
     *
     * @param omsOrderMsg 订单信息
     */
    public void sendUserToMq(OmsOrderMsg omsOrderMsg) {
        //设置消息传递格式
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        //设置交换机
        rabbitTemplate.setExchange(env.getProperty(MqConstant.ORDER_SUCCESS_EXCHANGE));
        String orderSuccessKey = env.getProperty(MqConstant.ORDER_SUCCESS_ROUTING_KEY);
        if (StringUtils.isBlank(orderSuccessKey)) {
            log.error("没有查到路由，请检查消息队列");
            return;
        }
        //设置路由
        rabbitTemplate.setRoutingKey(orderSuccessKey);
        //发送消息
        rabbitTemplate.convertAndSend(omsOrderMsg, message -> {
            MessageProperties messageProperties = message.getMessageProperties();
            //设置消息的持久化模型为持久化
            messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            //设置消息头，表示传输的消息直接指定为某个类实例，消费者在监听时可以直接定义该类对象参数进行接收
            messageProperties.setHeader(
                    AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, OmsOrderMsg.class);
            return message;
        });
        log.info("发送订单信息至指定队列");

    }
}
