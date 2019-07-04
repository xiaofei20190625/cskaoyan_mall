package com.cskaoyan.mall;

import com.cskaoyan.mall.bean.CategorySpecific;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.SpecificItem;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.mapper.EchoBrandAndCatMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.service.EchoBrandAndCatService;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.service.StorageService;
import com.cskaoyan.mall.typeHandler.StringToStingrArrayHandler;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    @Test
    public void mytest1() {
        ResponseVO<PageVO<Goods>> responseVO = goodsService.queryAll(1, 10);
        System.out.println(responseVO);
    }

    @Test
    public void mytest2() {
        List<SpecificItem> specificItems = echoBrandAndCatService.echoBrand();
        System.out.println(specificItems);
    }
    @Test
    public void mytest3() {
        List<Goods> goods = goodsMapper.queryAll();
        System.out.println(goods);
    }
    @Test
    public void mytest4() {
        StringToStingrArrayHandler stringToStingrArrayHandler = new StringToStingrArrayHandler();
        String[] strings = stringToStingrArrayHandler.stringToStringArray("[\"http://yanxuan.nosdn.127.net/4eb09e08ac9de543d2291d27a6be0b54.jpg\", \"http://yanxuan.nosdn.127.net/0c9eb81c7594dbe42802ff1ebbece51a.jpg\", \"http://yanxuan.nosdn.127.net/8cfc7b6bfd28687ab3399da08e5ba61b.jpg\", \"http://yanxuan.nosdn.127.net/b98cfd7f197b62abd1679321eae253a6.jpg\"]");
        System.out.println(strings);
    }
    @Test
    public void mytest5() {
        Storage storage = new Storage("asdasd", "asdqwe", "asdasd", 1111, "asdasd", new Date(), new Date(), false);
        int i = storageService.insert(storage);
        System.out.println(storage);
    }

    @Test
    public void mytest6() {
        Goods goods = new Goods();
        goods.setGallery(new String[]{"123", "asdas"});
        goods.setHot(false);
        goods.setGoodsSn("asdasd");
        goods.setName("asdasd");
        int insert = goodsMapper.insert(goods);
        System.out.println(insert);
    }
}
