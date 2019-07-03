package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    /*----------查询商品列表-----------*/
    //http://192.168.2.100:8081/admin/goods/list?page=1&limit=20&sort=add_time&order=desc
    @RequestMapping("goods/list")
    @ResponseBody
    public ResponseVO getGoodsList(int page, int limit, String add_time, String order) {
        ResponseVO<PageVO<Goods>> responseVO = goodsService.queryAll(page, limit);
        return responseVO;
    }


}
