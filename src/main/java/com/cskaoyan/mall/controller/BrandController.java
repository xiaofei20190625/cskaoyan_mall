package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.service.BrandService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 22:12
 */
@Controller
public class BrandController {
    @Autowired
    BrandService brandService;
    @RequestMapping("brand/list")
    @ResponseBody
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public ResponseVO<PageVO> getPageBrands(int page, int limit, String sort, String order, String id, String name){
        if (id == null) id = "";
        if (name == null) name = "";
        PageVO<Brand> pageVO = brandService.getPageBrand(page, limit, sort, order, id, name);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(pageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
