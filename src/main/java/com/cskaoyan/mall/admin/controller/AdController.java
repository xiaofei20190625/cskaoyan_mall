package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Ad;
import com.cskaoyan.mall.admin.service.AdService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/ad")
public class AdController {

    @Autowired
    AdService adService;

    /*http://localhost:8080/admin/ad/list?page=1&limit=20&sort=add_time&order=desc
    http://192.168.2.100:8081/admin/ad/list?page=1&limit=20&name=1&sort=add_time&order=desc*/
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseVO<PageVO> getList(int page, int limit, String sort, String order,String  name ,String content){
        if (name == null ) name = "";
        if(content == null) content = "" ;
        PageVO<Ad> adPageVO = adService.getList(page, limit ,sort ,order , name , content );
        ResponseVO<PageVO> responseVO = new ResponseVO<>();
        responseVO.setData(adPageVO);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return  responseVO;
    }

    @PostMapping("/update")
    public  ResponseVO update(@RequestBody Ad ad) {
        int update = adService.updateById(ad);
        ResponseVO<Integer> responseVO = new ResponseVO<>();
        if (update == 1) {
            responseVO.setData(update);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return responseVO;
    }

    @RequestMapping("/delete")
    public ResponseVO delete(@RequestBody Ad ad){
        int delete = adService.delete(ad);
        ResponseVO<Integer> responseVO = new ResponseVO<>();
        if(delete == 1){
            responseVO.setData(delete);
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
        }
        return  responseVO;
    }



}
