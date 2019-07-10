package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<Collect> findCollectPageByValueIdAndUserId(@Param("userId") String userId,
                                                    @Param("valueId") String valueId,
                                                    @Param("sort") String sort,
                                                    @Param("order") String order);

    Collect verifyCollectByUserIdAndGoodsId(@Param("goodsId") int goodsId,@Param("userId") Integer userId);
}