package com.mall.order.feign;

import com.mall.common.core.constant.ProjectInfo;
import com.mall.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 库存的远程调用
 *
 * @author wqi
 * @date 2022/3/28
 */
@FeignClient(ProjectInfo.G_WARE_NAME)
public interface WareFeign {


    /**
     * 通知仓储服务扣减库存
     *
     * @param skuId skuId
     * @return
     */
    @PostMapping(value = "ware/wmswaresku/lockStock")
    R lockStock(@RequestParam("skuId") String skuId);
}
