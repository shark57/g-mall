package com.mall.ware.util;


import java.util.concurrent.atomic.AtomicLong;

/**
 * 仓储服务中的id创建
 *
 * @author wqi
 * @date 2022/3/27
 */
public class IdUtil {

    /**
     * todo 此处需要处理分布式下id不唯一的情况
     */
    private Long port;

    /**
     * skuId计数器
     */
    static AtomicLong skuId = new AtomicLong();

    /**
     * purchaseId计数器
     */

    static AtomicLong purchaseId = new AtomicLong();

    /**
     * 创建skuId
     *
     * @return skuId
     */
    public static Long getSkuId() {
        return skuId.getAndIncrement();
    }

    /**
     * 获取采购单Id
     * purchaseId
     *
     * @return
     */
    public static Long getPurchaseId() {
        return purchaseId.getAndIncrement();
    }
}
