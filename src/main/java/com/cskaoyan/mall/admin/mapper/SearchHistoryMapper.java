package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Keyword;
import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.wx.bean.Search;
import com.cskaoyan.mall.wx.bean.SearchHotHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    SearchHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);

    List<SearchHistory> findSearchHistoryPageByKeywordAndUserId(@Param("userId") String userId,
                                                                @Param("keyword") String keyword,
                                                                @Param("sort") String sort,
                                                                @Param("order") String order);

    SearchHotHistory findSearchHistory();

    List<Keyword> findSearchHistoryKeywordList(Integer userId);

    List<SearchHotHistory> findSearchHotHistory();

    List findSearchHelp(@Param("keyword") String keyword);
}