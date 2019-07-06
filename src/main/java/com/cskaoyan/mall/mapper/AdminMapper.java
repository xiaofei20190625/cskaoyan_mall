package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.vo.ResponseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

   // int updateByPrimaryKey(Admin record);

    List<Admin> findAdminPage(@Param("username") String username);

    int roleupdate(Admin record);

    int admindelete(Admin id);

    int adminadd(Admin record);
}