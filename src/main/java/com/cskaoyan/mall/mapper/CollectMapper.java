package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.vo.PageVO;

import java.util.List;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<Collect> findCollectPage();

    List<Collect> findCollectByUserId(String userId);

    List<Collect> findCollectPageByValueIdAndUserId(String userId, String valueId);

    List<Collect> findCollectPageByValueId(String valueId);
}