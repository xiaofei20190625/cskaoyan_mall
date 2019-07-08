package com.cskaoyan.mall;

import com.cskaoyan.mall.admin.bean.Goods;
import com.cskaoyan.mall.admin.bean.GrouponRules;
import com.cskaoyan.mall.admin.mapper.CommentMapper;
import com.cskaoyan.mall.admin.mapper.GoodsMapper;
import com.cskaoyan.mall.admin.mapper.GrouponRulesMapper;
import com.cskaoyan.mall.admin.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/8 12:28
 * @Description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityTest {

    /*@Autowired

    GoodsMapper goodsMapper;
    @Test
    public  void  test1( ){
        String sort = "add_time";
        String order = "desc";
        String goodsId="";
        List<Goods> goodsList = goodsMapper.getListRecord(sort ,order , goodsId);
        System.out.println("goodsList = " + goodsList.size());
    }
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Test
    public  void  test2(){
        GrouponRules rules = grouponRulesMapper.findGoodsId(1039051);
        System.out.println("rules = " + rules);


    }*/

}
