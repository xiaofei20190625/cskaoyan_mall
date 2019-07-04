package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.service.BrandService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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

    @RequestMapping("brand/delete")
    @ResponseBody
    public ResponseVO deleteBrandById(@RequestBody Brand brand){
        int delete = brandService.deleteBrandById(brand);
        ResponseVO<Object> responseVO = new ResponseVO<>();
        if (delete == 1){
            responseVO.setData(delete);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return responseVO;
    }

    @RequestMapping("brand/create")
    @ResponseBody
    public ResponseVO<Brand> createBrand(@RequestBody Brand brand){
        Date date = new Date();
        brand.setAddTime(date);
        int create = brandService.createBrand(brand);
        ResponseVO<Brand> responseVO = new ResponseVO<>();
        if (create == 1){
            responseVO.setData(brand);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }
}
