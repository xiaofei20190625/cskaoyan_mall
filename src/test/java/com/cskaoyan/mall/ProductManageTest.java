package com.cskaoyan.mall;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductManageTest {
    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    EchoBrandAndCatService echoBrandAndCatService;
    @Autowired
    EchoBrandAndCatMapper echoBrandAndCatMapper;
    @Autowired
    StorageService storageService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    AttributeService attributeService;
    @Autowired
    AttributeMapper attributeMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    SpecificationMapper specificationMapper;
    @Autowired
    SpecificationService specificationService;
    @Autowired
    ProductService productService;
    @Test
    public void mytest1() {
        ResponseVO<PageVO<Goods>> responseVO = goodsService.queryAll(1, 10);
        System.out.println(responseVO);
    }
    @Test
    public void mytest2() {
        List<Attribute> attributes = attributeService.queryByGoodsId(1006002);
        System.out.println(attributes);
    }
    @Test
    public void mytest3() {
        Goods goods = new Goods();
        goods.setId(1181032);
        goods.setGoodsSn("asdasdasda");
        goods.setName("asdasd");
        int update = goodsService.update(goods);
        System.out.println(update);
    }
    @Test
    public void mytest4() {
        Product product = new Product();
        product.setId(284);
        product.setGoodsId(12312);
        product.setSpecifications(new String[]{"asd", "asdasd"});
        BigDecimal bigDecimal = new BigDecimal("123");
        product.setPrice(bigDecimal);
        product.setNumber(123);
        int i = productService.updateByPrimaryKey(product);
        System.out.println(i);

    }
    @Test
    public void mytest5() {
        Attribute attribute = new Attribute();
        attribute.setId(902);
        attribute.setGoodsId(66666);
        attribute.setAttribute("asdasd");
        attribute.setValue("qweqwe");
        int i = attributeService.updateByPrimaryKey(attribute);
        System.out.println(i);

    }
    @Test
    public void mytest6() {
        Attribute attribute = new Attribute();
        Integer id = attribute.getId();
        System.out.println(id);
    }



}
