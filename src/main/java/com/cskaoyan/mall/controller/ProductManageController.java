package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.service.EchoBrandAndCatService;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.utils.FileNameUtils;
import com.cskaoyan.mall.utils.FileUtils;
import com.cskaoyan.mall.vo.OperationVO;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProductManageController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    EchoBrandAndCatService echoBrandAndCatService;
    /*----------查询商品列表-----------*/
    @RequestMapping("goods/list")
    @ResponseBody
    public ResponseVO getGoodsList(int page, int limit, String add_time, String order) {
        ResponseVO<PageVO<Goods>> responseVO = goodsService.queryAll(page, limit);
        return responseVO;
    }
    /*-----------新增商品------------*/
    //品牌和目录的回显
    @RequestMapping("goods/catAndBrand")
    @ResponseBody
    public ResponseVO echoBrandAndCat() {
        List<SpecificItem> brandList = echoBrandAndCatService.echoBrand();
        List<CategorySpecific> categoryList = echoBrandAndCatService.echoCategory();
        EchoBrandAndCat echoBrandAndCat = new EchoBrandAndCat(brandList, categoryList);
        ResponseVO<EchoBrandAndCat> responseVO = new ResponseVO<>(echoBrandAndCat, "成功", 0);
        return responseVO;
    }
    //新增操作的执行
    @RequestMapping("goods/create")
    @ResponseBody
    public OperationVO doInsert(List<Attribute> attributes, Goods goods, List<Product> products, List<Specification> specifications) {
        return null;
    }

    /*----------编辑商品------------*/








}
