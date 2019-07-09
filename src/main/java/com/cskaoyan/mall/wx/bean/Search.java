package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.Keyword;
import com.cskaoyan.mall.admin.bean.SearchHistory;

import java.util.Date;
import java.util.List;

public class Search {
    SearchHotHistory defaultKeyword;
    List<Keyword> historyKeywordList;
    List<SearchHotHistory> hotKeywordList;

    public SearchHotHistory getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(SearchHotHistory defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<Keyword> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<Keyword> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }

    public List<SearchHotHistory> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<SearchHotHistory> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }
}