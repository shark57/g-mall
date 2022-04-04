package com.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.R;
import com.mall.ware.entity.WmsWareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author wqi
 * @date 2022-03-27 20:57:05
 */
public interface WmsWareSkuService extends IService<WmsWareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 扣减库存业务逻辑
     *
     * @param skuId
     * @return
     */
    R lockStock(String skuId);
}

