package com.mall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.Query;

import com.mall.ware.dao.WmsPurchaseDao;
import com.mall.ware.entity.WmsPurchaseEntity;
import com.mall.ware.service.WmsPurchaseService;


@Service("wmsPurchaseService")
public class WmsPurchaseServiceImpl extends ServiceImpl<WmsPurchaseDao, WmsPurchaseEntity> implements WmsPurchaseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WmsPurchaseEntity> page = this.page(
                new Query<WmsPurchaseEntity>().getPage(params),
                new QueryWrapper<WmsPurchaseEntity>()
        );

        return new PageUtils(page);
    }

}