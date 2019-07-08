package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Storage;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface StorageService {

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);



    PageVO<Storage> findStoragePage(int page, int limit,Storage storage);

    int storageupdate(Storage storage);

    int storagedelete(Storage storage);
}
