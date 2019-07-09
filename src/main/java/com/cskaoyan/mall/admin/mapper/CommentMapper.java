package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> queryAll();

    List<Comment> fuzzyQuery(@Param("userId") String userId,@Param("valueId") String valueId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

}