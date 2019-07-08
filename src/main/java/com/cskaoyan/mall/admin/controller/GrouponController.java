package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.GoodsAndGrouponAndGrouponRules;
import com.cskaoyan.mall.admin.service.GrouponService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.GoodsAndGrouponAndGrouponRules;
import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.mapper.GoodsMapper;
import com.cskaoyan.mall.admin.mapper.GrouponMapper;
import com.cskaoyan.mall.admin.mapper.GrouponRulesMapper;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.service.GrouponService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/5 15:42
 * @Description TODO
 */
@RestController
@RequestMapping("/groupon")
public class GrouponController {

    @Autowired
    GrouponService grouponService;
    @Autowired
    GrouponMapper grouponMapper ;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper ;

    /*http://192.168.2.100:8081/admin/groupon/listRecord?page=1&limit=20&goodsId=1&sort=add_time&order=desc*/
    @RequestMapping(value = "/listRecord", method = RequestMethod.GET)
    public ResponseVO<PageVO> getListRecord(int page, int limit, String sort, String order, String goodsId) {
        List<GoodsAndGrouponAndGrouponRules> ggrList = new ArrayList<>();
        String[] s = {} ;
        //分次查询
        if (goodsId == null) goodsId = "";
        List<Goods> goodsList = goodsMapper.getListRecord(sort ,order , goodsId);
        System.out.println("goodsList.size() = " + goodsList.size());
        for (Goods goods:goodsList ) {
            int id = goods.getId();
            GrouponRules rules = grouponRulesMapper.findGoodsId(id);
            if(rules != null){
                GrouponRules selectGrouponRules = rules;
                Goods selectGoods = goods;
                Groupon groupon = grouponMapper.findRulesId(selectGrouponRules.getId());
                if(groupon != null){
                    Groupon selectGroupon = groupon;
                    GoodsAndGrouponAndGrouponRules result = new GoodsAndGrouponAndGrouponRules(selectGoods , selectGroupon , selectGrouponRules ,s);
                    ggrList.add(result);
                }
            }
        }
        //分页
        PageHelper.startPage(page, limit);
        PageInfo<GoodsAndGrouponAndGrouponRules> ggrPageInfo = new PageInfo<>(ggrList);
        PageVO<GoodsAndGrouponAndGrouponRules> ggrPageVO = new PageVO<>(ggrPageInfo.getTotal(),ggrPageInfo.getList());
        ResponseVO<PageVO> responseVO = new ResponseVO<>(ggrPageVO ,"成功" , 0);
        return responseVO;
    }
}
