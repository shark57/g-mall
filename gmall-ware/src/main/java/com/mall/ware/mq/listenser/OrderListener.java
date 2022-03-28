package com.mall.ware.mq.listenser;

import com.alibaba.fastjson.JSONObject;
import com.mall.common.entity.order.OmsOrderMsg;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author wqi
 * @date 2022/3/28
 */
@Slf4j
@Service
public class OrderListener {

    /**
     * 消息监听
     *
     * @param message message
     * @param channel channel
     */
    @RabbitListener(queues = "${order.success.queue}")
    @RabbitHandler
    public void sendEmailS(OmsOrderMsg omsOrderMsg, Message message, Channel channel) throws IOException {
        //获取消息属性
        MessageProperties messageProperties = message.getMessageProperties();
        //获取消息分发时的全局唯一标识
        long deliveryTag = messageProperties.getDeliveryTag();
        try {
//            OmsOrderMsg omsOrderMsg = JSONObject.parseObject(message.getBody(), OmsOrderMsg.class);
            log.info("订单信息：{}", omsOrderMsg.toString());
            // 手动删除消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("消息确认success！");
        } catch (IOException e) {
            log.error("消息确认失败fail！", e);
            // 解锁失败 将消息重新放回队列，让别人消费
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }

    }
}
