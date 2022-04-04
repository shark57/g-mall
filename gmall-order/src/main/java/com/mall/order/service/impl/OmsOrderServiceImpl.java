package com.mall.order.service.impl;

import com.mall.common.core.util.R;
import com.mall.common.entity.order.OmsOrderMsg;
import com.mall.order.constant.OrderStatusType;
import com.mall.order.feign.WareFeign;
import com.mall.order.mq.provider.OrderProvider;
import com.mall.order.util.IdUtil;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.Query;

import com.mall.order.dao.OmsOrderDao;
import com.mall.order.entity.OmsOrderEntity;
import com.mall.order.service.OmsOrderService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("omsOrderService")
@Slf4j
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderDao, OmsOrderEntity> implements OmsOrderService {

    @Resource
    OrderProvider orderProvider;
    @Resource
    private Environment env;
    @Resource
    WareFeign wareFeign;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderEntity> page = this.page(
                new Query<OmsOrderEntity>().getPage(params),
                new QueryWrapper<OmsOrderEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * todo 1.调用product查询商品详情 2.创建订单 3.锁定库存
     *
     * @param omsOrder
     * @return
     */
//    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional
    @Override
    public R createOrder(OmsOrderEntity omsOrder) {
        omsOrder.setStatus(OrderStatusType.UN_PAYMENT.getStatus());
//        omsOrder.setCreateTime(LocalDateTime.now());
        omsOrder.setOrderSn(IdUtil.getOrderSn());

//        R r = wareFeign.lockStock("1");
        wareFeign.lockStock("1");
        log.info("扣减库存已经调用");
        try {
            super.save(omsOrder);
            OmsOrderMsg omsOrderMsg = new OmsOrderMsg();
            BeanUtils.copyProperties(omsOrder, omsOrderMsg);
            orderProvider.sendUserToMq(omsOrderMsg);
        } catch (Exception e) {
            log.error("订单创建失败，错误信息：{}", e.getMessage());
            throw e;
        }
        int i = 1/0;
        return R.ok();
    }

}