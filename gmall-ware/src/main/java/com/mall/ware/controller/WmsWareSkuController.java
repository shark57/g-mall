package com.mall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mall.ware.entity.WmsWareSkuEntity;
import com.mall.ware.service.WmsWareSkuService;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.R;


/**
 * 商品库存
 *
 * @author wqi
 * @date 2022-03-27 20:57:05
 */
@RestController
@RequestMapping("ware/wmswaresku")
@Slf4j
public class WmsWareSkuController {
    @Autowired
    private WmsWareSkuService wmsWareSkuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:wmswaresku:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = wmsWareSkuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:wmswaresku:info")
    public R info(@PathVariable("id") Long id) {
        WmsWareSkuEntity wmsWareSku = wmsWareSkuService.getById(id);

        return R.ok().put("wmsWareSku", wmsWareSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:wmswaresku:save")
    public R save(@RequestBody WmsWareSkuEntity wmsWareSku) {
        wmsWareSkuService.save(wmsWareSku);

        return R.ok();
    }

    /**
     * 锁定库存
     *
     * @param skuId
     * @return
     */
    @PostMapping("/lockStock")
    //@RequiresPermissions("ware:wmswaresku:save")
    public R lockStock(@RequestParam("skuId") String skuId) {
        wmsWareSkuService.lockStock(skuId);
        return R.ok("锁定库存成功！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:wmswaresku:update")
    public R update(@RequestBody WmsWareSkuEntity wmsWareSku) {
        wmsWareSkuService.updateById(wmsWareSku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:wmswaresku:delete")
    public R delete(@RequestBody Long[] ids) {
        wmsWareSkuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
