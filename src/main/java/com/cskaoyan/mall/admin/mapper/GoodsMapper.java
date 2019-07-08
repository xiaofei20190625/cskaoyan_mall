package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<Goods> queryAll();


    List<Goods> fuzzyQuery(@Param("goodsSn") String goodsSn, @Param("name") String name);

    Goods queryOneById(int id);

    int insert(Goods goods);

    int delete(@Param("goods") Goods goods);

    int update(@Param("goods") Goods goods);
}
