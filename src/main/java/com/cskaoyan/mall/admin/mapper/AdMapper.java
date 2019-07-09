package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Ad;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(@RequestBody  Ad record);

    int updateByPrimaryKey(Ad record);

    List<Ad> getList(@Param("sort") String sort,  @Param("order") String order ,
                @Param("name")String  name ,@Param("content") String content);

    int create(Ad ad);

    List<Ad> getWxBannerList();
}