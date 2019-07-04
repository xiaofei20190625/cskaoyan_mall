package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 22:13
 */
public interface BrandMapper {
    List<Brand> queryPageBrand(@Param("sort")String sort, @Param("order")String order,
                               @Param("id")String id, @Param("name")String name);

    int deleteBrandById(@Param("id")int id);
}
