package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.service.*;
import com.cskaoyan.mall.vo.OperationVO;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class ProductManageController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    AttributeService attributeService;
    @Autowired
    ProductService productService;
    @Autowired
    SpecificationService specificationService;
    @Autowired
    EchoBrandAndCatService echoBrandAndCatService;
    @Autowired
    CategoryService categoryService;
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
    public OperationVO doInsert(@RequestBody GoodsInsert goodsInsert) {
        List<Attribute> attributes = goodsInsert.getAttributes();
        Goods goods = goodsInsert.getGoods();
        List<Product> products = goodsInsert.getProducts();
        List<Specification> specifications = goodsInsert.getSpecifications();
        //插入goods
        goods.setOnSale(true);
        goods.setNew(true);
        goods.setHot(false);
        goods.setDeleted(false);
        Date now = new Date();
        goods.setAddTime(now);
        goods.setUpdateTime(now);
        //insert1-->goods插入返回的结果
        //insert2-->product插入返回的结果
        //insert3-->specification插入返回的结果
        //insert4-->specification插入返回的结果
        int insert1 = goodsService.insert(goods);
        int insert2 = 0;
        int insert3 = 0;
        int insert4 = 0;
        int goodsId = goods.getId();
        //插入product
        for (Product product : products) {
            product.setGoodsId(goodsId);
            product.setAddTime(now);
            product.setUpdateTime(now);
            product.setDeleted(false);
            insert2 = productService.insert(product);
        }
        //插入specification
        for (Specification specification : specifications) {
            specification.setAddTime(now);
            specification.setUpdateTime(now);
            specification.setDeleted(false);
            specification.setGoodsId(goodsId);
            insert3 = specificationService.insertSelective(specification);
        }
        //插入attribute
        for (Attribute attribute : attributes) {
            attribute.setGoodsId(goodsId);
            attribute.setAddTime(now);
            attribute.setUpdateTime(now);
            insert4 = attributeService.insertSelective(attribute);

        }
        OperationVO operationVO = null;
        if (insert1 ==1 && insert2 ==1 && insert3 == 1 && insert4 == 1) {
            operationVO = new OperationVO(0, "成功");
        } else {
            operationVO = new OperationVO(401, "参数不对");
        }
        return operationVO;
    }

    /*----------编辑商品------------*/
    @RequestMapping("goods/detail")
    @ResponseBody
    public ResponseVO echoGoods(int id) {
        Goods goods = goodsService.queryOneById(id);
        int categoryId1 = goods.getCategoryId();
        int categoryId2 = categoryService.queryPidById(categoryId1);
        int[] categoryIds =  new int[]{categoryId2, categoryId1};
        List<Attribute> attributes = attributeService.queryByGoodsId(id);
        List<Product> products = productService.queryByGoodsId(id);
        List<Specification> specifications = specificationService.queryByGoodsId(id);
        GoodsDetail goodsDetail = new GoodsDetail(attributes, categoryIds, goods, products, specifications);
        ResponseVO<GoodsDetail> responseVO = new ResponseVO<>(goodsDetail, "成功", 0);
        return responseVO;
    }

    /*----------删除商品------------*/
    @RequestMapping("goods/delete")
    @ResponseBody
    public OperationVO doDelete(@RequestBody Goods goods) {
        OperationVO operationVO;
        int delete = goodsService.delete(goods);
        if (delete == 1) {
            operationVO = new OperationVO(0, "成功");
        } else {
            operationVO = new OperationVO(401, "删除失败");
        }
        return operationVO;

    }








}
