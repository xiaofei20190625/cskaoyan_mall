package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.*;

import com.cskaoyan.mall.admin.service.GoodsService;

import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.wx.bean.*;

import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/9 Time 12:06
 */
@Controller
@RequestMapping("wx/goods")
public class GoodsWxController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    AttributeService attributeService;
    @Autowired
    BrandService brandService;
    @Autowired
    CommentService commentService;
    @Autowired
    GrouponService grouponService;
    @Autowired
    IssueService issueService;
    @Autowired
    ProductService productService;
    @Autowired
    SpecificationService specificationService;
    @Autowired
    CollectService collectService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    FootprintService footprintService;




    @RequestMapping("count")
    @ResponseBody
    public BaseRespVO goodsCount(){
        int count = goodsService.getGoodsNum();
        HashMap data = new HashMap();
        data.put("goodsCount",count);
        BaseRespVO baseRespVo = BaseRespVO.ok(data);
        return baseRespVo;
    }

    @RequestMapping("detail")
    @ResponseBody
    public BaseRespVO goodsDetail(Integer id, HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        System.out.println(userId);
        GoodsDetailWx data = getGoodsDetailById(id, userId);
        BaseRespVO baseRespVo = BaseRespVO.ok(data);
        //添加足迹
        //用户已登录，执行添加足迹
        Date now = new Date();
        if (userId != null) {
            //判断该商品是否已经加入足迹列表
            Footprint footprint = footprintService.selectByUidAndGoodsId(userId, id);
            //该商品没有加入过足迹列表
            if (footprint == null) {
                footprint = new Footprint();
                footprint.setUserId(userId);
                footprint.setGoodsId(id);
                footprint.setAddTime(now);
                footprint.setUpdateTime(now);
                int insert = footprintService.insert(footprint);
            }
            //该商品加入过足迹，只需要更新时间
            else {
                footprint.setUpdateTime(now);
                int update = footprintService.updateByPrimaryKey(footprint);
            }
        }

        return baseRespVo;
    }
    private GoodsDetailWx getGoodsDetailById(int goodsId, Integer userId) {
        GoodsDetailWx goodsDetailWx = new GoodsDetailWx();
        Goods goods = goodsService.queryOneById(goodsId);

        //Attribute
        List<Attribute> attribute = attributeService.getAttributeByGoodsId(goodsId);
        //Brand
        Brand brand = null;
        if (goods.getBrandId() != 0 && goods.getBrandId() != null){
            brand = brandService.getBrandById(goods.getBrandId());
        }
        //Comment
        HashMap<String, Object> comment = new HashMap<>();
        List<CommentWx> comments = commentService.getCommentsByGoodsId(goodsId);
        int count = commentService.getCommentCountByGoodsId(goodsId);
        comment.put("data",comments);
        comment.put("count", count);
        //Groupon
        List<Groupon> groupon = grouponService.getGrouponRulesByGoodsId(goodsId);
        //Info
        Goods info = goodsService.queryOneById(goodsId);
        //Issue
        List<Issue> issue = issueService.getAllIssue();
        //Product
        List<Product> productList = productService.queryByGoodsId(goodsId);
        //Shareimage
        String shareImage = "";

        //SpecificationList
        List<SpecificationWx> specificationList = specificationService.querySpecificationWxByGoodsId(goodsId);

        //collect
        int isCollected = 0;
        if (userId != null){
            isCollected = collectService.verifyCollectByUserIdAndGoodsId(goodsId, userId);
        }


        goodsDetailWx.setAttribute(attribute);
        goodsDetailWx.setBrand(brand);
        goodsDetailWx.setComment(comment);
        goodsDetailWx.setGroupon(groupon);
        goodsDetailWx.setInfo(info);
        goodsDetailWx.setIssue(issue);
        goodsDetailWx.setProductList(productList);
        goodsDetailWx.setShareImage(shareImage);
        goodsDetailWx.setSpecificationList(specificationList);
        goodsDetailWx.setUserHasCollect(isCollected);
        return goodsDetailWx;
    }

    @RequestMapping("related")
    @ResponseBody
    public BaseRespVO goodsRelated(Integer id){
        List<GoodsWx> relatedGoods = goodsService.getWxRelatedGoods(id);
        HashMap<String, List> goodsList = new HashMap<>();
        goodsList.put("goodsList", relatedGoods);
        BaseRespVO baseRespVO = BaseRespVO.ok(goodsList);
        return baseRespVO;
    }

    @RequestMapping("category")
    @ResponseBody
    public BaseRespVO goodsCategory(Integer id){
        HashMap<String, Object> currentSubCategory = getSubCategoryById(id);
        BaseRespVO baseRespVO = BaseRespVO.ok(currentSubCategory);
        return baseRespVO;
    }

    private HashMap<String, Object> getSubCategoryById(Integer currentSubCategoryId) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer parentCategoryId = categoryService.queryPidById(currentSubCategoryId);

        List<Category> brotherCategory = categoryService.queryAllCategoriesL2(parentCategoryId);
        Category currentCategory = categoryService.getCategoryById(currentSubCategoryId);
        Category parentCategory = categoryService.getCategoryById(parentCategoryId);

        hashMap.put("brotherCategory", brotherCategory);
        hashMap.put("currentCategory",currentCategory);
        hashMap.put("parentCategory", parentCategory);
        return hashMap;
    }

    private PageVO<List> pageInfo(int page, int size, List list) {
        PageHelper.startPage(page, size);
        PageInfo<List> pageInfo = new PageInfo<>(list);
        PageVO<List> listPageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        return listPageVO;
    }

    /*//goods/list?brandId=1001003&page=1&size=100
    @ApiOperation(value = "根据品牌id获取品牌商品")
    @RequestMapping("list")
    @ResponseBody
    public BaseRespVO getPageBrandsGoods(String keyword,String brandId,int page,int size,Boolean isNew,String order,String sort,Integer categoryId){
        PageVO<List> listPageVO =null;
        List<Goods> goodsList = null;
        if(brandId==null){
            goodsList = goodsService.getPageBrandsGoodsByIds(isNew,order,sort,categoryId,keyword);
            //***********************************
            //分页
            listPageVO = pageInfo(page, size, goodsList);
        }
        if (categoryId==null){
            goodsList = goodsService.getPageBrandsGoodsById(brandId);
            //***********************************
            //分页
            listPageVO = pageInfo(page, size, goodsList);
        }
        //***********************************
        HashSet<Integer> categoryIdSet = new HashSet<>();
        for (Goods goods : goodsList){
            categoryIdSet.add(goods.getCategoryId());
        }
        int[] cetegoryIdArr = new int[categoryIdSet.size()];
        for (int i = 0; i < cetegoryIdArr.length; i++) {
            cetegoryIdArr[i] =
        }
//        List<CategoryL1> allCategories = categoryService.getAllCategories();
        List<CategoryL1> filterCategoryList = categoryService.getFilterCategoryList(keyword);

        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("count",listPageVO.getTotal());
        //filterCategoryList分类
        data.put("filterCategoryList",filterCategoryList);
        data.put("goodsList",listPageVO.getItems());
        //***********************************
        return BaseRespVO.ok(data);

    }*/
    //goods/list?brandId=1001003&page=1&size=100
    @ApiOperation(value = "根据品牌id获取品牌商品")
    @RequestMapping("list")
    @ResponseBody
    public BaseRespVO getPageBrandsGoods(String keyword,String brandId,int page,int size,Boolean isNew,String order,String sort,Integer categoryId){
        PageVO<List> listPageVO =null;
        List<Goods> goodsList = null;
        if(brandId==null){
            goodsList = goodsService.getPageBrandsGoodsByIds(isNew,order,sort,categoryId,keyword);
            //***********************************
            //分页
            listPageVO = pageInfo(page, size, goodsList);
        }
        if (categoryId==null){
            goodsList = goodsService.getPageBrandsGoodsById(brandId);
            //***********************************
            //分页
            listPageVO = pageInfo(page, size, goodsList);
        }
        //***********************************

//        List<CategoryL1> filterCategoryList = categoryService.getAllCategories();
        List<Category> filterCategoryList = categoryService.getFilterCategoryList(keyword);

        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("count",listPageVO.getTotal());
        //filterCategoryList分类
        data.put("filterCategoryList",filterCategoryList);
        data.put("goodsList",listPageVO.getItems());
        //***********************************
        return BaseRespVO.ok(data);

    }

}
