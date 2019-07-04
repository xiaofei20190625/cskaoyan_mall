package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CategoryL1;
import com.cskaoyan.mall.bean.L1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 16:21
 */
public interface CategoryMapper {
    List<CategoryL1> queryAllCategories();
    List<L1> queryAllL1();
    int deleteCategory(@Param("id") int id);
}
