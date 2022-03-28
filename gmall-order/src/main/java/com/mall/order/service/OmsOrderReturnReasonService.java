package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.order.entity.OmsOrderReturnReasonEntity;

import java.util.Map;

/**
 * 退货原因
 *
 * @author wqi
 * @date 2022-03-27 20:12:46
 */
public interface OmsOrderReturnReasonService extends IService<OmsOrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

