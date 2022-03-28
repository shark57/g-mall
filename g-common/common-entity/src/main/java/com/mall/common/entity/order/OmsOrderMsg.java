package com.mall.common.entity.order;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用于消息传递的订单信息
 *
 * @author wqi
 * @date 2022/3/28
 */
@Data
@ToString
public class OmsOrderMsg  {

    /**
     * id
     */
    public Long id;
    /**
     * member_id
     */
    public Long memberId;
    /**
     * 订单号
     */
    public String orderSn;
    /**
     * 使用的优惠券
     */
    public Long couponId;
    /**
     * create_time
     */
    //public LocalDateTime createTime;
    /**
     * 用户名
     */
    public String memberUsername;
    /**
     * 订单总额
     */
    public BigDecimal totalAmount;
    /**
     * 应付总额
     */
    public BigDecimal payAmount;
    /**
     * 运费金额
     */
    public BigDecimal freightAmount;
    /**
     * 促销优化金额（促销价、满减、阶梯价）
     */
    public BigDecimal promotionAmount;
    /**
     * 积分抵扣金额
     */
    public BigDecimal integrationAmount;
    /**
     * 优惠券抵扣金额
     */
    public BigDecimal couponAmount;
    /**
     * 后台调整订单使用的折扣金额
     */
    public BigDecimal discountAmount;
    /**
     * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
     */
    public Integer payType;
    /**
     * 订单来源[0->PC订单；1->app订单]
     */
    public Integer sourceType;
    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    public Integer status;
    /**
     * 物流公司(配送方式)
     */
    public String deliveryCompany;
    /**
     * 物流单号
     */
    public String deliverySn;
    /**
     * 自动确认时间（天）
     */
    public Integer autoConfirmDay;
    /**
     * 可以获得的积分
     */
    public Integer integration;
    /**
     * 可以获得的成长值
     */
    public Integer growth;
    /**
     * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
     */
    public Integer billType;
    /**
     * 发票抬头
     */
    public String billHeader;
    /**
     * 发票内容
     */
    public String billContent;
    /**
     * 收票人电话
     */
    public String billReceiverPhone;
    /**
     * 收票人邮箱
     */
    public String billReceiverEmail;
    /**
     * 收货人姓名
     */
    public String receiverName;
    /**
     * 收货人电话
     */
    public String receiverPhone;
    /**
     * 收货人邮编
     */
    public String receiverPostCode;
    /**
     * 省份/直辖市
     */
    public String receiverProvince;
    /**
     * 城市
     */
    public String receiverCity;
    /**
     * 区
     */
    public String receiverRegion;
    /**
     * 详细地址
     */
    public String receiverDetailAddress;
    /**
     * 订单备注
     */
    public String note;
    /**
     * 确认收货状态[0->未确认；1->已确认]
     */
    public Integer confirmStatus;
    /**
     * 删除状态【0->未删除；1->已删除】
     */
    public Integer deleteStatus;
    /**
     * 下单时使用的积分
     */
    public Integer useIntegration;
/*    *//**
     * 支付时间
     *//*
    public LocalDateTime paymentTime;
    *//**
     * 发货时间
     *//*
    public LocalDateTime deliveryTime;
    *//**
     * 确认收货时间
     *//*
    public LocalDateTime receiveTime;
    *//**
     * 评价时间
     *//*
    public LocalDateTime commentTime;
    *//**
     * 修改时间
     *//*
    public LocalDateTime modifyTime;*/
}
