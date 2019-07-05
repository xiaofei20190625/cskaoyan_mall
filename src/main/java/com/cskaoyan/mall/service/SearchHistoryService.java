package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.vo.PageVO;

public interface SearchHistoryService {

    PageVO<SearchHistory> findSearchHistoryPageByKeywordAndUserId(int page, int limit, String userId, String keyword, String sort, String order);

}
