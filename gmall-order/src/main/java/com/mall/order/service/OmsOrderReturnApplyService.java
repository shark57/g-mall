package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.order.entity.OmsOrderReturnApplyEntity;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author wqi
 * @date 2022-03-27 20:12:46
 */
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

