package com.mall.product.pms.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.R;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mall.product.pms.entity.PmsCategoryEntity;
import com.mall.product.pms.service.PmsCategoryService;


/**
 * 商品三级分类
 *
 * @author wqi
 * @email 16388mail@gmail.com
 * @date 2021-12-09 00:11:17
 */
@RestController
@RequestMapping("product/pms/category")
@Slf4j
public class PmsCategoryController {
    @Autowired
    private PmsCategoryService pmsCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("pms:pmscategory:list")
    public R list(@RequestParam Map<String, Object> params) {
        log.info("product/pms/category/list");
        PageUtils page = pmsCategoryService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("tree")
    public R getCategoryTree() {
        log.info("product/pms/category/tree");
        List<PmsCategoryEntity> categoryTree = pmsCategoryService.getCategoryTree();
        return R.ok(categoryTree);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{catId}")
//    @RequiresPermissions("pms:pmscategory:info")
    public R infoPath(@PathVariable("catId") Long catId) {
        log.info("我在测试sdk，时间:{}", LocalDateTime.now());
        return pmsCategoryService.getById(catId);

    }


    /**
     * 信息
     */
    @RequestMapping("/info")

//    @RequiresPermissions("pms:pmscategory:info")
    public R info(@RequestParam("catId") Long catId) {
        return pmsCategoryService.getById(catId);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("pms:pmscategory:save")
    public R save(@RequestBody PmsCategoryEntity pmsCategory) {
        pmsCategoryService.save(pmsCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("pms:pmscategory:update")
    public R update(@RequestBody PmsCategoryEntity pmsCategory) {
        pmsCategoryService.updateById(pmsCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("pms:pmscategory:delete")
    public R delete(@RequestBody Long[] catIds) {
        pmsCategoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
