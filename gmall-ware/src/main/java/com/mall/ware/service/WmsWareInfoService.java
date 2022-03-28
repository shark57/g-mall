package com.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.core.util.PageUtils;
import com.mall.ware.entity.WmsWareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author wqi
 * @date 2022-03-27 20:57:05
 */
public interface WmsWareInfoService extends IService<WmsWareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

