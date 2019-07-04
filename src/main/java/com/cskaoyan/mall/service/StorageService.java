package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Storage;

public interface StorageService {

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}
