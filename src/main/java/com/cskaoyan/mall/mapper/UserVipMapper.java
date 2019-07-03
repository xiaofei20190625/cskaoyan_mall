package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.UserVip;

import java.util.List;

public interface UserVipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVip record);

    int insertSelective(UserVip record);

    UserVip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVip record);

    int updateByPrimaryKey(UserVip record);

    List<UserVip> selectUserVip();
}