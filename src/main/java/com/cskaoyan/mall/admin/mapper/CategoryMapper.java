package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Category;
import com.cskaoyan.mall.admin.bean.CategoryL1;
import com.cskaoyan.mall.admin.bean.L1;
import com.cskaoyan.mall.wx.bean.Channel;
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

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int queryPidById(int id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);



    List<Category> getCategoryListById(int brandId);

    List<Channel> getWxChannelList();


}

