package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<Goods> queryAll();


    List<Goods> fuzzyQuery(@Param("goodsSn") String goodsSn, @Param("name") String name);

    Goods queryOneById(int id);

    int insert(Goods goods);

    int delete(@Param("goods") Goods goods);

    int update(@Param("goods") Goods goods);

    List<Goods> getListRecord(@Param("sort") String sort, @Param("order")String order,@Param("goodsId") String goodsId);
}
