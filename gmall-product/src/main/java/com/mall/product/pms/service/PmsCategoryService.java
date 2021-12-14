package com.mall.product.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.product.pms.entity.PmsCategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author wqi
 * @email 16388mail@gmail.com
 * @date 2021-12-09 00:11:17
 */
public interface PmsCategoryService extends IService<PmsCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取分类的树结构
     *
     * @return
     */
    List<PmsCategoryEntity> getCategoryTree();
}

