package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.R;
import com.mall.order.entity.OmsOrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author wqi
 * @date 2022-03-27 20:12:46
 */
public interface OmsOrderService extends IService<OmsOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 创建订单
     *
     * @param omsOrder
     * @return
     */
    R createOrder(OmsOrderEntity omsOrder);
}

