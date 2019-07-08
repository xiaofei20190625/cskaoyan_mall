package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Coupon;
import com.cskaoyan.mall.admin.bean.CouponUser;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.admin.service.CouponUserService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @Autowired
    CouponUserService couponUserService ;

    /*http://192.168.2.100:8081/admin/coupon/list?page=1&limit=20&name=1&type=0&status=0&sort=add_time&order=desc*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseVO<PageVO> getList(int page, int limit, String sort, String order, String name, String type, String status) {
        if (name == null) name = "";
        if (type == null) type = "";
        if (status == null) status = "";
        PageVO<Coupon> adPageVO = couponService.getList(page, limit, sort, order, name, type, status);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(adPageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseVO<Coupon> create(@RequestBody Coupon coupon) {
        int insert = couponService.create(coupon);
        ResponseVO<Coupon> responseVO = new ResponseVO<>();
        if (insert == 1) {
            responseVO.setData(coupon);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return responseVO;
    }

    /*    http://localhost:8080/admin/coupon/update*/
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseVO<Coupon> update(@RequestBody Coupon coupon) {
        int update = couponService.update(coupon);
        ResponseVO<Coupon> responseVO = new ResponseVO<>();
        if (update == 1) {
            responseVO.setData(coupon);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

    /* http://localhost:8080/admin/coupon/read?id=9*/
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseVO<Coupon> read(int id) {
        Coupon coupon = couponService.getCouponById(id);
        ResponseVO<Coupon> responseVO = new ResponseVO<>();
        if (coupon != null) {
            responseVO.setData(coupon);
            responseVO.setErrno(0);
            responseVO.setErrmsg("成功");
        }
        return responseVO;
    }

/*    http://192.168.2.100:8081/admin/coupon/listuser?page=1&limit=20&couponId=8&userId=1&status=0&sort=add_time&order=desc*/
    @RequestMapping(value = "/listuser", method = RequestMethod.GET)
    public ResponseVO<PageVO> listuser(int page, int limit, int couponId , String userId ,String sort, String order, String status) {
        if (userId == null) userId = "";
        if (status == null) status = "";
        PageVO<CouponUser> couponUserPageVO = couponUserService.getListUser(page, limit, sort, order, couponId, userId, status);
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(couponUserPageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

/*    http://localhost:8080/admin/coupon/delete*/
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseVO delete(@RequestBody Coupon coupon){
        int delete = couponService.delete(coupon);
        ResponseVO<Integer> responseVO = new ResponseVO<>();
        if(delete == 1){
            responseVO.setData(delete);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return  responseVO;
    }


}
