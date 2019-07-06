package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.GoodsAndGrouponAndGrouponRules;
import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.service.GrouponService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex_Cheng
 * @date 2019/7/5 15:42
 * @Description TODO
 */
@RestController
@RequestMapping("/groupon")
public class GrouponController {

    @Autowired
    GrouponService grouponService ;

    /*http://192.168.2.100:8081/admin/groupon/listRecord?page=1&limit=20&goodsId=1&sort=add_time&order=desc*/
    @RequestMapping(value = "/listRecord", method = RequestMethod.GET)
    public ResponseVO<PageVO> getListRecord(int page, int limit, String sort, String order, String goodsId) {
        if (goodsId == null) goodsId = "";
        PageVO<GoodsAndGrouponAndGrouponRules> grouponRulesPageVO = grouponService.getListRecord(page, limit, sort, order, goodsId);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(grouponRulesPageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }


}
