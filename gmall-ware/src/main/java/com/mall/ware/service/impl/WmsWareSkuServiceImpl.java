package com.mall.ware.service.impl;

import com.mall.common.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.Query;

import com.mall.ware.dao.WmsWareSkuDao;
import com.mall.ware.entity.WmsWareSkuEntity;
import com.mall.ware.service.WmsWareSkuService;


@Service("wmsWareSkuService")
@Slf4j
public class WmsWareSkuServiceImpl extends ServiceImpl<WmsWareSkuDao, WmsWareSkuEntity> implements WmsWareSkuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WmsWareSkuEntity> page = this.page(
                new Query<WmsWareSkuEntity>().getPage(params),
                new QueryWrapper<WmsWareSkuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R lockStock(String skuId) {
        log.info("扣减库存被调用，skuId：{}", skuId);
        WmsWareSkuEntity wmsWareSku = new WmsWareSkuEntity();
        wmsWareSku.setSkuId(5L);
        wmsWareSku.setSkuName("我在测试");
        super.save(wmsWareSku);
        return R.ok();
    }

}