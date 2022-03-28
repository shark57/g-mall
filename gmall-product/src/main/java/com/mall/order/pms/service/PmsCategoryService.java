package com.mall.order.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.R;
import com.mall.order.pms.entity.PmsCategoryEntity;

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

    default PageUtils queryPage(Map<String, Object> params){
        return null;
    };

    /**
     * 获取分类的树结构
     *
     * @return
     */
    default List<PmsCategoryEntity> getCategoryTree(){
        return null;
    };

    /**
     *
     * @param catId
     * @return
     */
    R getById(Long catId);


}

