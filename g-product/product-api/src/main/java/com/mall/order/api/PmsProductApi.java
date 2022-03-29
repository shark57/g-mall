package com.mall.order.api;


import com.mall.common.core.constant.ProjectInfo;
import com.mall.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wqi
 * @date 2022/3/29
 */
@FeignClient(ProjectInfo.G_PRODUCT_NAME)
public interface PmsProductApi {

    @GetMapping("product/pms/category/info")
    R infoPath(@RequestParam("catId") Long catId);

}
