package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.service.GrouponRulesService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/groupon")
public class GrouponRulesController {

    @Autowired
    GrouponRulesService grouponRulesService;

    /*http://192.168.2.100:8081/admin/groupon/list?page=1&limit=20&goodsId=1&sort=add_time&order=desc*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseVO<PageVO> getList(int page, int limit, String sort, String order, String goodsId) {
        if (goodsId == null) goodsId = "";
        PageVO<GrouponRules> grouponRulesPageVO = grouponRulesService.getList(page, limit, sort, order, goodsId);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(grouponRulesPageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }


}
