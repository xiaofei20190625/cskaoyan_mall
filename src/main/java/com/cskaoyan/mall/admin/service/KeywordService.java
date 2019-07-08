package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Keyword;
import com.cskaoyan.mall.admin.vo.PageVO;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 20:31
 */
public interface KeywordService {
    PageVO<Keyword> getPageKeyword(int page, int limit, String sort, String order, String keyword, String url);

    int deleteKeywordById(Keyword keyword);

    int createKeyword(Keyword keyword);

    int updateKeyword(Keyword keyword);

    Keyword getKeywordById(Integer id);
}
