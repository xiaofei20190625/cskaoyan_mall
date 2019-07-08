package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Brand;
import com.cskaoyan.mall.admin.vo.PageVO;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 22:13
 */
public interface BrandService {
    PageVO<Brand> getPageBrand(int page, int limit, String sort, String order, String id, String name);

    int deleteBrandById(Brand brand);

    Brand createBrand(Brand brand);

    int updateBrand(Brand brand);

    Brand getBrandById(Integer id);
}
