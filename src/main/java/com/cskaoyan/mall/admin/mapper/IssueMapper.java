package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Issue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 19:53
 */
public interface IssueMapper {
    List<Issue> queryPageIssue(@Param("sort") String sort,
                               @Param("order") String order,
                               @Param("question") String question);

    int deleteIssueById(@Param("id") Integer id);

    int insertIssue(Issue issue);

    int updateByPrimaryKey(Issue issue);

    Issue selectByPrimaryKey(@Param("id") Integer id);
}
