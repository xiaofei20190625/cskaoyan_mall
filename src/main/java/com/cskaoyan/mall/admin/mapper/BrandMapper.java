package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Brand;
import com.cskaoyan.mall.wx.bean.BrandWx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> queryPageBrand(@Param("sort") String sort,
                               @Param("order") String order,
                               @Param("id") String id,
                               @Param("name") String name);

    int deleteBrandById(@Param("id") int id);

    int insertBrand(Brand brand);

    List<BrandWx> getWxBrandList();
}
