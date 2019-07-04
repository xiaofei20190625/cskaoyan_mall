package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.vo.PageVO;

public interface SearchHistoryService {
    PageVO<SearchHistory> findSearchHistoryPage(int page, int limit);

    PageVO<SearchHistory> findSearchHistoryByUserId(int page, int limit, String userId);

    PageVO<SearchHistory> findSearchHistoryPageByKeywordAndUserId(int page, int limit, String userId, String keyword);

    PageVO<SearchHistory> findSearchHistoryPageByKeyword(int page, int limit, String keyword);
}
