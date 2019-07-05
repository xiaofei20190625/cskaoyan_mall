package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> queryPageBrand(@Param("sort") String sort, @Param("order") String order,
                               @Param("id") String id, @Param("name") String name);

    int deleteBrandById(@Param("id") int id);

    int insertBrand(@Param("brand") Brand brand);

}
