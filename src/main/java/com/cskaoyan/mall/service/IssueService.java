package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.vo.PageVO;

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
