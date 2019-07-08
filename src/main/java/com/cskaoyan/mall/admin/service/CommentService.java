package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Comment;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;

public interface CommentService {
    ResponseVO<PageVO<Comment>> queryAll(int page, int limit);

    ResponseVO<PageVO<Comment>> fuzzyQuery(int page, int limit, String userId, String valueId);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Comment record);

    int delete(Integer id);
}
