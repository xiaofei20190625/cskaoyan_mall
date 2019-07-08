package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Issue;
import com.cskaoyan.mall.admin.vo.PageVO;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 19:52
 */
public interface IssueService {
    PageVO<Issue> getPageIssue(int page, int limit, String sort, String order, String question);

    int deleteIssueById(Issue issue);

    int createIssue(Issue issue);

    int updateIssue(Issue issue);

    Issue getIssueById(Integer id);
}
