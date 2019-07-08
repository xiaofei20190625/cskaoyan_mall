package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Keyword;
import com.cskaoyan.mall.admin.mapper.KeywordMapper;
import com.cskaoyan.mall.admin.service.KeywordService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 20:32
 */
@Service
public class KeywordServiceImpl implements KeywordService {
    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public PageVO<Keyword> getPageKeyword(int page, int limit, String sort, String order, String keyword, String url) {
        PageHelper.startPage(page, limit);
        List<Keyword> keywords = keywordMapper.queryPageKeyword(sort, order, keyword, url);
        PageInfo<Keyword> pageInfo = new PageInfo<>(keywords);
        PageVO<Keyword> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        return pageVO;
    }

    @Override
    public int deleteKeywordById(Keyword keyword) {
        return keywordMapper.deleteKeywordById(keyword.getId());
    }

    @Override
    public int createKeyword(Keyword keyword) {
        Date date = new Date();
        keyword.setAddTime(date);
        keyword.setUpdateTime(date);
        keyword.setSortOrder(50);
        keyword.setDeleted(false);
        return keywordMapper.insertKeyword(keyword);
    }

    @Override
    public int updateKeyword(Keyword keyword) {
        return keywordMapper.updateByPrimaryKey(keyword);
    }

    @Override
    public Keyword getKeywordById(Integer id) {
        return keywordMapper.selectByPrimaryKey(id);
    }
}
