package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.Keyword;
import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.admin.mapper.SearchHistoryMapper;
import com.cskaoyan.mall.wx.bean.Search;
import com.cskaoyan.mall.wx.bean.SearchHotHistory;
import com.cskaoyan.mall.wx.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public Search findSearchHistory(Integer userId) {
        Search search = new Search();
        SearchHotHistory searchHistory = searchHistoryMapper.findSearchHistory();
        search.setDefaultKeyword(searchHistory);
        List<Keyword> keywords = searchHistoryMapper.findSearchHistoryKeywordList(userId);
        search.setHistoryKeywordList(keywords);
        List<SearchHotHistory> searchHotHistory = searchHistoryMapper.findSearchHotHistory();
        search.setHotKeywordList(searchHotHistory);

        return search;
    }

    @Override
    public List findSearchhelp(String keyword) {
        keyword="%"+keyword+"%";
        List help = searchHistoryMapper.findSearchHelp(keyword);
        return help;
    }
}
