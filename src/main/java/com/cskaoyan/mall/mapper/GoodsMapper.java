package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<Goods> queryAll();

    Goods queryOneById(int id);

    int insert(Goods goods);

    int delete(@Param("goods") Goods goods);
}
