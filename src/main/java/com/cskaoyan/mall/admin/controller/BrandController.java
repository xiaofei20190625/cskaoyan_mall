package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Brand;
import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
        int create = brandService.createBrand(brand);
        ResponseVO<Brand> responseVO = new ResponseVO<>();
        if (create == 1){
            responseVO.setData(brand);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

    @RequestMapping("brand/update")
    @ResponseBody
    public ResponseVO<Brand> updateBrand(@RequestBody Brand brand){
        int create = brandService.updateBrand(brand);
        ResponseVO<Brand> responseVO = new ResponseVO<>();
        if (create == 1){
            Brand newBrand = brandService.getBrandById(brand.getId());
            responseVO.setData(newBrand);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }
}
