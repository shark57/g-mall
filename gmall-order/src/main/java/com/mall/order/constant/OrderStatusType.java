package com.mall.order.constant;

import lombok.Getter;

/**
 * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
 *
 * @author wqi
 * @date 2022/3/27
 */
public enum OrderStatusType {
    UN_PAYMENT(0, "待付款"),
    WAIT_SEND(1, "待发货"),
    SEND(2, "已发货"),
    COMPLETE(3, "已完成"),
    CLOSE(4, "已关闭"),
    INVALID(5, "无效订单");


    /**
     * 状态
     */
    @Getter
    private Integer status;
    /**
     * 描述
     */

    private String desc;

    OrderStatusType(Integer state, String desc) {
        this.status = state;
        this.desc = desc;
    }
}
