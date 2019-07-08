package com.cskaoyan.mall.admin.service.impl;


import com.cskaoyan.mall.admin.bean.Storage;
import com.cskaoyan.mall.admin.mapper.StorageMapper;
import com.cskaoyan.mall.admin.service.StorageService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public PageVO<Storage> findStoragePage(int page, int limit, Storage storage) {

        PageHelper.startPage(page,limit);
        List<Storage> storageList = storageMapper.findStoragePage(storage);
        PageInfo<Storage> rolePageInfo = new PageInfo<>(storageList);
        PageVO<Storage> rolePageVO = new PageVO<>(rolePageInfo.getTotal(), rolePageInfo.getList());
        return rolePageVO;
    }

    @Override
    public int storageupdate(Storage storage) {
        storage.setAddTime(new Date());
        storage.setUpdateTime(new Date());
        int update= storageMapper.storageupdate(storage);
        return update;


    }

    @Override
    public int storagedelete(Storage storage) {
        storage.setDeleted(true);
        int delete = storageMapper.storagedelete(storage);
        return delete;
    }

}
