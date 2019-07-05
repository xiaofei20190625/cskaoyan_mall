package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.vo.ResponseVO;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

   // int updateByPrimaryKey(Admin record);

    List<Admin> findAdminPage();
    int roleupdate(Admin record);

    int admindelete(Admin id);
}