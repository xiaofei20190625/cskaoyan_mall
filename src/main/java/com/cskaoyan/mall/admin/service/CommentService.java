package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Comment;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.CommentWx;

import java.util.List;

public interface CommentService {
    ResponseVO<PageVO<Comment>> queryAll(int page, int limit);

    ResponseVO<PageVO<Comment>> fuzzyQuery(int page, int limit, String userId, String valueId);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Comment record);

    int delete(Integer id);

    List<CommentWx> getCommentsByGoodsId(int goodsId);

    int getCommentCountByGoodsId(int goodsId);
}
