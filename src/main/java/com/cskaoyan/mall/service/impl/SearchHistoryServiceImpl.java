package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.PageList;
import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.mapper.SearchHistoryMapper;
import com.cskaoyan.mall.service.SearchHistoryService;
import com.cskaoyan.mall.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public PageVO<SearchHistory> findSearchHistoryPageByKeywordAndUserId(int page, int limit, String userId, String keyword, String sort, String order) {
        List<SearchHistory> searchHistoryPage = searchHistoryMapper.findSearchHistoryPageByKeywordAndUserId(userId,keyword,sort,order);
        PageVO<SearchHistory> pagevo = new PageList<SearchHistory>().pagevo(page, limit, searchHistoryPage);
        return pagevo;
    }
}
