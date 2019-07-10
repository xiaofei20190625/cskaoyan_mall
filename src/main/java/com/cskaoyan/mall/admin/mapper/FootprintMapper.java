package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Footprint;
import com.cskaoyan.mall.wx.bean.EchoFootprint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootprintMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    Footprint selectByPrimaryKey(Integer id);

    Footprint selectByUidAndGoodsId(@Param("userId") Integer userId,@Param("goodsId") Integer goodsId);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    List<Footprint> findFootprintPageByGoodsIdAndUserId(@Param("userId") String userId,
                                                        @Param("goodsId") String goodsId,
                                                        @Param("sort") String sort,
                                                        @Param("order") String order);
    List<EchoFootprint> echoFootprintListByUid(int userId);


}