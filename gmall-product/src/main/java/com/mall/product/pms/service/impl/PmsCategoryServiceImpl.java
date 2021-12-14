package com.mall.product.pms.service.impl;

import com.mall.common.core.constant.PmsCategoryConstant;
import com.mall.common.core.util.PageUtils;
import com.mall.common.core.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mall.product.pms.dao.PmsCategoryDao;
import com.mall.product.pms.entity.PmsCategoryEntity;
import com.mall.product.pms.service.PmsCategoryService;



@Service("pmsCategoryService")
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryDao, PmsCategoryEntity> implements PmsCategoryService {

    @Autowired
    PmsCategoryDao pmsCategoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsCategoryEntity> page = this.page(
                new Query<PmsCategoryEntity>().getPage(params),
                new QueryWrapper<>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<PmsCategoryEntity> getCategoryTree() {
        List<PmsCategoryEntity> records = pmsCategoryDao.selectList(null);
        return constructTree(records);
    }

    /**
     * 构建节点树
     *
     * @param pmsCategoryEntities
     * @return
     */
    private List<PmsCategoryEntity> constructTree(List<PmsCategoryEntity> pmsCategoryEntities) {
        List<PmsCategoryEntity> pmsCategoryEntityList = new ArrayList<>();
        List<PmsCategoryEntity> rootNodes = getRootNode(pmsCategoryEntities);
        for (PmsCategoryEntity rootNode : rootNodes) {
            PmsCategoryEntity pmsCategoryEntity = buildChildTree(rootNode, pmsCategoryEntities);
            pmsCategoryEntityList.add(pmsCategoryEntity);
        }
        return pmsCategoryEntityList;
    }

    /**
     * 递归构建子节点
     *
     * @param pmsCategory
     * @param all
     * @return
     */
    PmsCategoryEntity buildChildTree(PmsCategoryEntity pmsCategory, List<PmsCategoryEntity> all) {
        List<PmsCategoryEntity> children = new ArrayList<>();
        for (PmsCategoryEntity pmsCategoryEntity : all) {
            if (pmsCategoryEntity.getParentCid().equals(pmsCategory.getCatId())) {
                children.add(buildChildTree(pmsCategoryEntity, all));
            }
        }
        pmsCategory.setChildren(children);
        return pmsCategory;
    }

    /**
     * 获取根节点
     *
     * @param pmsCategoryEntities
     * @return
     */
    List<PmsCategoryEntity> getRootNode(List<PmsCategoryEntity> pmsCategoryEntities) {
        List<PmsCategoryEntity> rootNodes = new ArrayList<>();
        pmsCategoryEntities.forEach(pmsCategoryEntity -> {
            if (PmsCategoryConstant.rootCode.equals(pmsCategoryEntity.getParentCid())) {
                rootNodes.add(pmsCategoryEntity);
            }
        });
        return rootNodes;
    }

}