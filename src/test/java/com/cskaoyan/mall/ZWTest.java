package com.cskaoyan.mall;

import com.cskaoyan.mall.admin.mapper.FootprintMapper;
import com.cskaoyan.mall.wx.bean.EchoFootprint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZWTest {
    @Autowired
    FootprintMapper footprintMapper;
    @Test
    public void mytest1() {
        List<EchoFootprint> echoFootprints = footprintMapper.echoFootprintListByUid(1);
        System.out.println(echoFootprints);
    }

}
