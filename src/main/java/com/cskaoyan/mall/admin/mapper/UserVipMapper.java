package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.UserVip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserVipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVip record);

    int insertSelective(UserVip record);

    UserVip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVip record);

    int updateByPrimaryKey(UserVip record);

    List<UserVip> selectUserVipByUsernameAndMobile(@Param("username") String username,
                                                   @Param("mobile")String mobile,
                                                   @Param("sort") String sort,
                                                   @Param("order") String order);

    UserVip findUserVip(String username);


}