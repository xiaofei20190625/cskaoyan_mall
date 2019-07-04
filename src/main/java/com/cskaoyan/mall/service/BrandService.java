package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.vo.PageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 22:13
 */
public interface BrandService {
    PageVO<Brand> getPageBrand(int page, int limit, String sort, String order, String id, String name);
    int deleteBrandById(Brand brand);
    int createBrand(Brand brand);
}
