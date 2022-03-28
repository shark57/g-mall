package com.mall.order.util;

import com.mall.common.core.util.SnowFlake;

/**
 * @author wqi
 * @date 2022/3/28
 */
public class IdUtil {
    //数据中心
    static long dataCenterId = 30;
    //机器标志
    static long machineId = 1;

    /**
     * todo
     * 此处在并发下会出现线程安全问题
     */
    static SnowFlake snowFlake = new SnowFlake(dataCenterId, machineId);

    /**
     * 获取订单号
     *
     * @return
     */
    public static String getOrderSn() {
        return String.valueOf(snowFlake.nextId());

    }
}
