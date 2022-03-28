package com.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.ware.entity.WmsWareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author wqi
 * @date 2022-03-27 20:57:05
 */
public interface WmsWareOrderTaskService extends IService<WmsWareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

