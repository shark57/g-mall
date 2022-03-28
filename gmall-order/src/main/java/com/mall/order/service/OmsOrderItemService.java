package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.R;
import com.mall.order.entity.OmsOrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author wqi
 * @date 2022-03-27 20:12:46
 */
public interface OmsOrderItemService extends IService<OmsOrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

