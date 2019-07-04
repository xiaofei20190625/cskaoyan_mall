package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.mapper.SearchHistoryMapper;
import com.cskaoyan.mall.service.SearchHistoryService;
import com.cskaoyan.mall.utils.PageUtil;
import com.cskaoyan.mall.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;
    @Override
    public PageVO<SearchHistory> findSearchHistoryPage(int page, int limit) {
        List<SearchHistory> searchHistoryPage = searchHistoryMapper.findSearchHistoryPage();
        PageVO<SearchHistory> pagevo = new PageUtil<SearchHistory>().pagevo(page, limit, searchHistoryPage);
        return pagevo;
    }

    @Override
    public PageVO<SearchHistory> findSearchHistoryByUserId(int page, int limit, String userId) {
        List<SearchHistory> searchHistoryPage = searchHistoryMapper.findSearchHistoryByUserId(userId);
        PageVO<SearchHistory> pagevo = new PageUtil<SearchHistory>().pagevo(page, limit, searchHistoryPage);
        return pagevo;
    }

    @Override
    public PageVO<SearchHistory> findSearchHistoryPageByKeywordAndUserId(int page, int limit, String userId, String keyword) {
        List<SearchHistory> searchHistoryPage = searchHistoryMapper.findSearchHistoryPageByKeywordAndUserId(userId,keyword);
        PageVO<SearchHistory> pagevo = new PageUtil<SearchHistory>().pagevo(page, limit, searchHistoryPage);
        return pagevo;
    }

    @Override
    public PageVO<SearchHistory> findSearchHistoryPageByKeyword(int page, int limit, String keyword) {
        List<SearchHistory> searchHistoryPage = searchHistoryMapper.findSearchHistoryPageByKeyword(keyword);
        PageVO<SearchHistory> pagevo = new PageUtil<SearchHistory>().pagevo(page, limit, searchHistoryPage);
        return pagevo;
    }


}
