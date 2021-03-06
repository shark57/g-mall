package com.mall.order.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.R;
import com.mall.order.api.PmsProductApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mall.order.entity.OmsOrderEntity;
import com.mall.order.service.OmsOrderService;

import javax.annotation.Resource;


/**
 * 订单
 *
 * @author wqi
 * @date 2022-03-27 20:12:46
 */
@RestController
@RequestMapping("order/omsorder")
@Slf4j
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;

    @Resource
    PmsProductApi pmsProductApi;

    @GetMapping("/info")
//    @RequiresPermissions("pms:pmscategory:info")
    public R infoPath(@RequestParam("catId") Long catId) {
        log.info("order服务，我在测试sdk，时间:{}", LocalDateTime.now());
        return pmsProductApi.infoPath(catId);

    }

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("order:omsorder:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = omsOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("order:omsorder:info")
    public R info(@PathVariable("id") Long id) {
        OmsOrderEntity omsOrder = omsOrderService.getById(id);

        return R.ok().put("omsOrder", omsOrder);
    }

    /**
     * 保存，创建订单
     */
    @PostMapping("/save")
    //@RequiresPermissions("order:omsorder:save")
    public R save(@RequestBody OmsOrderEntity omsOrder) {
        return omsOrderService.createOrder(omsOrder);

    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("order:omsorder:update")
    public R update(@RequestBody OmsOrderEntity omsOrder) {
        omsOrderService.updateById(omsOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("order:omsorder:delete")
    public R delete(@RequestBody Long[] ids) {
        omsOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
