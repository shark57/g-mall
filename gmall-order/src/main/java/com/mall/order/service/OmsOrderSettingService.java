package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.order.entity.OmsOrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author wqi
 * @date 2022-03-27 20:12:46
 */
public interface OmsOrderSettingService extends IService<OmsOrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

