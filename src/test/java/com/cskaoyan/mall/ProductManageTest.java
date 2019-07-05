package com.cskaoyan.mall;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.*;
import com.cskaoyan.mall.typeHandler.StringToStingrArrayHandler;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
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
        List<Product> products = productMapper.queryByGoodsId(1181000);
        System.out.println(products);
    }

}
