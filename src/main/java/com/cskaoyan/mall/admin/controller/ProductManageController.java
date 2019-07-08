package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.admin.vo.OperationVO;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin")
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
    @Autowired
    CommentService commentService;
    /*----------查询商品列表-----------*/
    //http://192.168.2.100:8081/admin/goods/list?page=1&limit=20&goodsSn=1&name=1&sort=add_time&order=desc
    @RequestMapping("goods/list")
    @ResponseBody
    public ResponseVO getGoodsList(int page, int limit,String goodsSn,String name,String sort, String order) {
        if (goodsSn == null && name == null) {
            ResponseVO<PageVO<Goods>> responseVO = goodsService.queryAll(page, limit);
            return responseVO;
        } else {
            ResponseVO<PageVO<Goods>> responseVO = goodsService.fuzzyQuery(page, limit, goodsSn, name);
            return responseVO;
        }
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

    //执行编辑操作
    @RequestMapping("goods/update")
    @ResponseBody
    public OperationVO doUpdate(@RequestBody GoodsInsert goodsInsert) {
        List<Attribute> attributes = goodsInsert.getAttributes();
        Goods goods = goodsInsert.getGoods();
        List<Product> products = goodsInsert.getProducts();
        List<Specification> specifications = goodsInsert.getSpecifications();
        //插入goods
        Date now = new Date();
        goods.setUpdateTime(now);
        //insert1-->goods插入返回的结果
        //insert2-->product插入返回的结果
        //insert3-->specification插入返回的结果
        //insert4-->specification插入返回的结果
        int update1 = goodsService.update(goods);
        int update2 = 0;
        int update3 = 0;
        int update4 = 0;
        int goodsId = goods.getId();
        //更新product
        for (Product product : products) {
            if (product.getId() == null || product.getId() == 0) {
                product.setGoodsId(goodsId);
                product.setAddTime(now);
                product.setUpdateTime(now);
                product.setDeleted(false);
                update2 = productService.insert(product);
            } else {
                product.setUpdateTime(now);
                update2 = productService.updateByPrimaryKey(product);
            }
        }
        //删除已经去掉了的product
        List<Product> productList = productService.queryByGoodsId(goodsId);
        for (Product item : productList) {
            //作为标记，0表示item已经不存在，1表示item还存在
            int flag = 0;
            for (Product product : products) {
                if (item.getId().intValue() == product.getId().intValue()) {
                    flag = 1;
                    break;
                }
            }
            //item已不存在，删除数据库中对应的项
            if (flag == 0) {
                update2 = productService.deleteByPrimaryKey(item.getId());
            }
        }
        //更新specification
        for (Specification specification : specifications) {
            if (specification.getId() == null || specification.getId() == 0) {
                specification.setAddTime(now);
                specification.setUpdateTime(now);
                specification.setDeleted(false);
                specification.setGoodsId(goodsId);
                update3 = specificationService.insertSelective(specification);
            } else {
                specification.setUpdateTime(now);
                update3 = specificationService.updateByPrimaryKey(specification);
            }
        }
        //删除已经去掉了的specification
        List<Specification> specificationList = specificationService.queryByGoodsId(goodsId);
        for (Specification item : specificationList) {
            int flag = 0;
            for (Specification specification : specifications) {
                /*System.out.println("a:" + specification.getId().intValue());
                System.out.println("b:" + item.getId().intValue());*/
                if (specification.getId().intValue() == item.getId().intValue()) {
                    flag = 1;
                    break;
                }
            }
            //item已不存在，执行删除
            if (flag == 0) {
                update3 = specificationService.deleteByPrimaryKey(item.getId());
            }

        }
        //更新attribute
        for (Attribute attribute : attributes) {
            if (attribute.getId() == null || attribute.getId() == 0) {
                attribute.setGoodsId(goodsId);
                attribute.setAddTime(now);
                attribute.setUpdateTime(now);
                update4 = attributeService.insertSelective(attribute);
            } else {
                attribute.setUpdateTime(now);
                update4 = attributeService.updateByPrimaryKey(attribute);
            }
        }
        //删除已经去掉的attribute
        List<Attribute> attributeList = attributeService.queryByGoodsId(goodsId);
        for (Attribute item : attributeList) {
            int flag = 0;
            for (Attribute attribute : attributes) {
                /*System.out.println("a:" + specification.getId().intValue());
                System.out.println("b:" + item.getId().intValue());*/
                if (attribute.getId().intValue() == item.getId().intValue()) {
                    flag = 1;
                    break;
                }
            }
            //item已不存在，执行删除
            if (flag == 0) {
                update4 = attributeService.deleteByPrimaryKey(item.getId());
            }
        }

        OperationVO operationVO = null;
        if (update1 == 1 && update2 ==1 && update3 == 1 && update4 == 1) {
            operationVO = new OperationVO(0, "成功");
        } else {
            operationVO = new OperationVO(401, "参数不对");
        }
        return operationVO;
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

    /*---------查询评论---------*/
    @RequestMapping("comment/list")
    @ResponseBody
    public ResponseVO getCommentList(int page, int limit,String userId, String valueId, String sort, String order) {
        if (userId == null && valueId == null) {
            ResponseVO<PageVO<Comment>> responseVO = commentService.queryAll(page, limit);
            return responseVO;
        } else {
            ResponseVO<PageVO<Comment>> responseVO = commentService.fuzzyQuery(page, limit, userId, valueId);
            return responseVO;
        }
    }

    /*---------删除评论---------*/
    @RequestMapping("comment/delete")
    @ResponseBody
    public OperationVO deleteComment(@RequestBody Comment comment) {
        Integer id = comment.getId();
        int delete = commentService.delete(id);
        OperationVO operationVO;
        if (delete == 1) {
            operationVO = new OperationVO(0, "成功");
            return operationVO;
        } else {
            operationVO = new OperationVO(1, "失败");
        }
        return operationVO;
    }
    /*------评论回复------*/
    //http://192.168.2.100:8081/admin/order/reply
    @RequestMapping("order/reply")
    @ResponseBody
    public OperationVO orderReply(@RequestBody CommentReply commentReply) {
        int commentId = commentReply.getCommentId();
        Comment comment = commentService.selectByPrimaryKey(commentId);
        OperationVO operationVO;
        //该评论的内容为空，执行更新评论的操作
        if ("".equals(comment.getContent())) {
            Date now = new Date();
            comment.setContent(commentReply.getContent());
            comment.setUpdateTime(now);
            int update = commentService.updateByPrimaryKey(comment);
            if (update == 1) {
                operationVO = new OperationVO(0, "成功");
            } else {
                operationVO = new OperationVO(1, "商品回复更新失败");
            }
        }
        //该评论的内容不为空返回响应的执行信息
        else {
            operationVO = new OperationVO(622,"订单商品已回复");
        }
        return operationVO;

    }









}
