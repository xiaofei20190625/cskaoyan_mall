package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Province;
import com.cskaoyan.mall.admin.service.RegionService;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 16:53
 */
@Controller
public class  RegionController {
    @Autowired
    RegionService regionService;

    @RequestMapping("region/list")
    @ResponseBody
    public ResponseVO<List> getRegionList(){
        ResponseVO<List> listResponseVO = new ResponseVO<>();
        List<Province> allRegion = regionService.getAllRegion();
        listResponseVO.setData(allRegion);
        listResponseVO.setErrmsg("成功");
        listResponseVO.setErrno(0);
        return listResponseVO;
    }
}
