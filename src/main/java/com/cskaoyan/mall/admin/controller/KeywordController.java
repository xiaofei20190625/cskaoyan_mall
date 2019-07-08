package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Keyword;
import com.cskaoyan.mall.admin.service.KeywordService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 20:31
 */
@Controller
@RequestMapping("admin")
public class KeywordController {
    @Autowired
    KeywordService keywordService;

    @RequestMapping("keyword/list")
    @ResponseBody
    public ResponseVO<PageVO> getPageKeywords(int page, int limit, String sort, String order, String keyword, String url){
        if (keyword == null) keyword = "";
        if (url == null) url = "";
        PageVO<Keyword> pageVO = keywordService.getPageKeyword(page, limit, sort, order, keyword, url);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(pageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping("keyword/delete")
    @ResponseBody
    public ResponseVO deleteKeywordById(@RequestBody Keyword keyword){
        int delete = keywordService.deleteKeywordById(keyword);
        ResponseVO<Object> responseVO = new ResponseVO<>();
        if (delete == 1){
            responseVO.setData(delete);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return responseVO;
    }

    @RequestMapping("keyword/create")
    @ResponseBody
    public ResponseVO<Keyword> createKeyword(@RequestBody Keyword keyword){
        int create = keywordService.createKeyword(keyword);
        ResponseVO<Keyword> responseVO = new ResponseVO<>();
        if (create == 1){
            responseVO.setData(keyword);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

    @RequestMapping("keyword/update")
    @ResponseBody
    public ResponseVO<Keyword> updateKeyword(@RequestBody Keyword keyword){
        keyword.setAddTime(new Date());
        int create = keywordService.updateKeyword(keyword);
        ResponseVO<Keyword> responseVO = new ResponseVO<>();
        if (create == 1){
            responseVO.setData(keyword);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;

    }


}
