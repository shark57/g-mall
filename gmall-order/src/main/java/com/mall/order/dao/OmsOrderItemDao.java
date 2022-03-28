package com.mall.order.dao;

import com.mall.order.entity.OmsOrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 *
 * @author wqi
 * @date 2022-03-27 20:12:46
 */
@Mapper
public interface OmsOrderItemDao extends BaseMapper<OmsOrderItemEntity> {

}
