package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    List<Storage> findStoragePage(Storage record);

    int storageupdate(Storage storage);

    int storagedelete(Storage storage);
}