package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.mapper.SearchHistoryMapper;
import com.cskaoyan.mall.wx.bean.Search;
import com.cskaoyan.mall.wx.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;
    @Override
    public List<Search> findSearchHistory(Search search) {
        List<Search> searchHistoryPage = searchHistoryMapper.findSearchHistory(search);
        return searchHistoryPage;
    }
}
