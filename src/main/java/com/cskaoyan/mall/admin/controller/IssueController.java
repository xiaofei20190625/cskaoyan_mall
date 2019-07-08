package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Issue;
import com.cskaoyan.mall.admin.service.IssueService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 19:52
 */
@Controller
@RequestMapping(value = "/admin/issue")
public class IssueController {
    @Autowired
    IssueService issueService;

    @ApiOperation(value = "获取问题列表")
    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<PageVO> getPageIssues(int page, int limit, String sort, String order, String question){
        if (question == null) question = "";
        PageVO<Issue> pageVO = issueService.getPageIssue(page, limit, sort, order, question);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(pageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @ApiOperation(value = "删除问题")
    @RequestMapping("delete")
    @ResponseBody
    public ResponseVO deleteIssueById(@RequestBody Issue issue){
        int delete = issueService.deleteIssueById(issue);
        ResponseVO<Object> responseVO = new ResponseVO<>();
        if (delete == 1){
            responseVO.setData(delete);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return responseVO;
    }

    @ApiOperation(value = "创建问题")
    @RequestMapping("create")
    @ResponseBody
    public ResponseVO<Issue> createIssue(@RequestBody Issue issue){
        int create = issueService.createIssue(issue);
        ResponseVO<Issue> responseVO = new ResponseVO<>();
        if (create == 1){
            responseVO.setData(issue);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

    @ApiOperation(value = "更新问题")
    @RequestMapping("update")
    @ResponseBody
    public ResponseVO<Issue> updateIssue(@RequestBody Issue issue){
        int create = issueService.updateIssue(issue);
        ResponseVO<Issue> responseVO = new ResponseVO<>();
        if (create == 1){
            Issue newIssue = issueService.getIssueById(issue.getId());
            responseVO.setData(newIssue);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

}
