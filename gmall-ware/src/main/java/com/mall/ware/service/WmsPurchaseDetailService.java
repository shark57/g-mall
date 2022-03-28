package com.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.ware.entity.WmsPurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author wqi
 * @date 2022-03-27 20:57:05
 */
public interface WmsPurchaseDetailService extends IService<WmsPurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

