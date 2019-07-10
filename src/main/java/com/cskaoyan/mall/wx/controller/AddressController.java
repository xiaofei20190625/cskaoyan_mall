package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.Region;
import com.cskaoyan.mall.admin.service.AddressService;
import com.cskaoyan.mall.wx.userwx.UserTokenManager;
import com.cskaoyan.mall.wx.vo.BaseRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("wx")
public class AddressController {
    @Autowired
    AddressService addressService;
    @RequestMapping("address/list")
    public BaseRespVO addressList(HttpServletRequest request) {

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************

        List<HashMap> Address = addressService.addresslist(userId);

        return BaseRespVO.ok(Address);
    }

    @RequestMapping("address/detail")
    public BaseRespVO addressdetail(HttpServletRequest request,int id) {

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************

        HashMap Address2 = addressService.addressdetail(id);

        return BaseRespVO.ok(Address2);
    }
    @RequestMapping("address/save")
    public BaseRespVO addressdetail(HttpServletRequest request, @RequestBody Address address1) {

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        address1.setUserId(userId);
   //     Address  addressSearchId= addressService.addressSearchId(address1.getId());

         /*  if (addressSearchId!=null) {
               int update = addressService.addressUpdate(address1);
               if (update != 1) {
                   BaseRespVO.fail();}
           }else {*/
               int insert = addressService.addressadd(address1);
               if (insert != 1) {
                   BaseRespVO.fail();
              /* }*/
           }
        return BaseRespVO.ok(address1.getId());

    }

    @RequestMapping("region/list")
    public BaseRespVO regionList(int pid) {

        List<Region> regionList = addressService.regionList(pid);

        return BaseRespVO.ok(regionList);
    }



}
