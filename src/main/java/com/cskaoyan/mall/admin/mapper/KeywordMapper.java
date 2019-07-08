package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Keyword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 20:39
 */
public interface KeywordMapper {
    List<Keyword> queryPageKeyword(@Param("sort") String sort,
                                   @Param("order") String order,
                                   @Param("keyword") String keyword,
                                   @Param("url") String url);

    int deleteKeywordById(@Param("id") Integer id);

    int insertKeyword(Keyword keyword);

    int updateByPrimaryKey(Keyword keyword);

    Keyword selectByPrimaryKey(@Param("id") Integer id);
}
