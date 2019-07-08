package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.SearchHistory;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.wx.bean.Search;
import com.cskaoyan.mall.wx.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx")
public class SearchComtroller {
    @Autowired
    SearchService searchService;
    @RequestMapping("search/index")
    public ResponseVO<List> historyList(Search search) {
        ResponseVO<List>  responseVO = new ResponseVO<>();
        responseVO = new ResponseVO<>();
        List<Search> search1 = searchService.findSearchHistory(search);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        responseVO.setData(search1);
        return responseVO;
    }


}
