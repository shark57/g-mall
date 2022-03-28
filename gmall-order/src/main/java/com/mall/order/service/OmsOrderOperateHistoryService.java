package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.order.entity.OmsOrderOperateHistoryEntity;

import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author wqi
 * @date 2022-03-27 20:12:46
 */
public interface OmsOrderOperateHistoryService extends IService<OmsOrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

