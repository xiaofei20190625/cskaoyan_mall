package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;

import java.util.List;

public interface CommentService {
    ResponseVO<PageVO<Comment>> queryAll(int page, int limit);

    ResponseVO<PageVO<Comment>> fuzzyQuery(int page, int limit, String userId, String valueId);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Comment record);

    int delete(Integer id);
}
