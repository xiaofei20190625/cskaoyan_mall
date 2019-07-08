package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.Keyword;
import com.cskaoyan.mall.admin.bean.SearchHistory;

import java.util.Date;
import java.util.List;

public class Search {
    SearchHistory defaultKeyword;
    List<Keyword> historyKeywordList;
    List<SearchHistory> hotKeywordList;

    public SearchHistory getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(SearchHistory defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<Keyword> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<Keyword> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }

    public List<SearchHistory> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<SearchHistory> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }
}