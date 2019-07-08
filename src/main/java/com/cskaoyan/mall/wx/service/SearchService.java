package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.bean.Search;

import java.util.List;

public interface SearchService {

    List<Search> findSearchHistory(Search search);
}
