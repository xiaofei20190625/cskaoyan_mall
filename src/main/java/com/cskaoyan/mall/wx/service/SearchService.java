package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.bean.Search;
import com.cskaoyan.mall.wx.bean.SearchHotHistory;

import java.util.List;

public interface SearchService {

    Search findSearchHistory(Integer userId);

    List findSearchhelp(String keyword);
}
