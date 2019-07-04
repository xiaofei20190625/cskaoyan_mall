package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.mapper.StorageMapper;
import com.cskaoyan.mall.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper storageMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Storage record) {
        return storageMapper.insert(record);
    }

    @Override
    public int insertSelective(Storage record) {
        return storageMapper.insertSelective(record);
    }

    @Override
    public Storage selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Storage record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Storage record) {
        return 0;
    }
}
