package com.cskaoyan.mall.admin.service;


import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface SearchHistoryService {

    PageVO<SearchHistory> findSearchHistoryPageByKeywordAndUserId(int page, int limit, String userId, String keyword, String sort, String order);





}
