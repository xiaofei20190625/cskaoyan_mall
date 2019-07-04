package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Coupon;
import com.cskaoyan.mall.service.CouponService;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService ;

    /*http://192.168.2.100:8081/admin/coupon/list?page=1&limit=20&name=1&type=0&status=0&sort=add_time&order=desc*/
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public ResponseVO<PageVO> getList(int page, int limit, String sort, String order, String  name , String type, String status){
        if (name == null ) name = "";
        if(type == null )type = "" ;
        if(status == null) status = "" ;
        PageVO<Coupon> adPageVO = couponService.getList(page, limit ,sort ,order , name , type , status );
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(adPageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return  responseVO;
    }

}
