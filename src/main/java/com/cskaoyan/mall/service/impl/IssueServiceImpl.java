package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Issue;
import com.cskaoyan.mall.mapper.IssueMapper;
import com.cskaoyan.mall.service.IssueService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 19:53
 */
@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    IssueMapper issueMapper;

    @Override
    public PageVO<Issue> getPageIssue(int page, int limit, String sort, String order, String question) {
        PageHelper.startPage(page, limit);
        List<Issue> issues = issueMapper.queryPageIssue(sort, order, question);
        PageInfo<Issue> pageInfo = new PageInfo<>(issues);
        PageVO<Issue> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        return pageVO;
    }

    @Override
    public int deleteIssueById(Issue issue) {
        return issueMapper.deleteIssueById(issue.getId());
    }

    @Override
    public int createIssue(Issue issue) {
        Date date = new Date();
        issue.setAddTime(date);
        issue.setUpdateTime(date);
        issue.setDeleted(false);
        return issueMapper.insertIssue(issue);
    }

    @Override
    public int updateIssue(Issue issue) {
        return issueMapper.updateByPrimaryKey(issue);
    }

    @Override
    public Issue getIssueById(Integer id) {
        return issueMapper.selectByPrimaryKey(id);
    }
}
