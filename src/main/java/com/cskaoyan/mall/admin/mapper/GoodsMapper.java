package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.wx.bean.FloorGoods;
import com.cskaoyan.mall.wx.bean.GoodsWx;
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


    List<Goods> getPageBrandsGoodsByIds(@Param("isNew") Boolean isNew,
                                       @Param("order") String order,
                                       @Param("sort") String sort,
                                       @Param("categoryId") int categoryId);

    List<Goods> getPageBrandsGoodsById(String brandId);

    int getGoodsNum();

    List<FloorGoods> getWxFloorGoods();

    List<GoodsWx> getWxHotGoodsList();

    List<GoodsWx> getWxNewGoodsList();

}
