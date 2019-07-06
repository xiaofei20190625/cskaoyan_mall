package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.mapper.CommentMapper;
import com.cskaoyan.mall.service.CommentService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public ResponseVO<PageVO<Comment>> queryAll(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Comment> comments = commentMapper.queryAll();
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        PageVO<Comment> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        ResponseVO<PageVO<Comment>> responseVO = new ResponseVO<>(pageVO, "成功", 0);
        return responseVO;
    }

    @Override
    public ResponseVO<PageVO<Comment>> fuzzyQuery(int page, int limit, String userId, String valueId) {
        PageHelper.startPage(page, limit);
        List<Comment> comments = commentMapper.fuzzyQuery( userId ,valueId);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        PageVO<Comment> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        ResponseVO<PageVO<Comment>> responseVO = new ResponseVO<>(pageVO, "成功", 0);
        return responseVO;
    }

    @Override
    public int delete(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }
}
