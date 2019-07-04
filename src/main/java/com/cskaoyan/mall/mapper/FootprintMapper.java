package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Footprint;
import com.cskaoyan.mall.vo.PageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootprintMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    Footprint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    List<Footprint> findFootprintPageByGoodsIdAndUserId(@Param("userId") String userId,
                                                        @Param("goodsId") String goodsId,
                                                        @Param("sort") String sort,
                                                        @Param("order") String order);

}