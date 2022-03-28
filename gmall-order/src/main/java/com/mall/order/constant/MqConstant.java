package com.mall.order.constant;

/**
 * mq定义的常量
 *
 * @author wqi
 * @date 2021/2/26
 */
public class MqConstant {


    /**
     * 创建订单成功，绑定的交换机
     */
    public static final String ORDER_SUCCESS_EXCHANGE = "order.success.exchange";

    /**
     * 绑定的队列
     */
    public static final String ORDER_SUCCESS_QUEUE = "order.success.queue";

    /**
     * 绑定的key
     */
    public static final String ORDER_SUCCESS_ROUTING_KEY = "order.success.routing.key";

    /**
     * 消息状态，失败
     */
    public static final String MESSAGE_ERROE = "error";
}
