package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.service.impl.AdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    AdServiceImpl adService;

    @RequestMapping("/list")
    public List<Ad> getList(int page, int limit, String sort, String order){
        List<Ad> list = adService.selectPageAd(page,limit, sort,order);
        return list;
    }


}
