package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.service.RoleSeervice;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemController {
    @Autowired
    AdminService adminService;
    @Autowired
    RoleSeervice roleSeervice;


/**   items: [{id: 12, username: "cskaoyan",…}, {id: 6, username: "123213213",…},…]
     total: 4
     errmsg: "成功"
     errno: 0/
 : {id: 12, username: "cskaoyan",…}
 avatar: "http://localhost:8080/wx/storage/fetch/lyk3wvv73404vfyeyvjr.jpg"
    id: 12
    roleIds: [1]
            0: 1
    username: "cskaoyan"*/

    @RequestMapping("admin/list")
    public ResponseVO<PageVO> adminList(int page,int limit, String sort, String order){
        PageVO<Admin> adminPageVO = adminService.findAdminPage(page,limit);
        ResponseVO<PageVO>  responseVO = new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        responseVO.setData(adminPageVO);
        return responseVO;
    }

    @RequestMapping("role/options")
    public ResponseVO<List> roleOptions(){
        ResponseVO<List>  responseVO = new ResponseVO<>();
        List<Role> roles = roleSeervice.queryOption();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        responseVO.setData(roles);
        return responseVO;
    }
    @RequestMapping("admin/update")
    public ResponseVO<Admin> roleupdate(@RequestBody Admin record){
        ResponseVO<Admin>  responseVO = new ResponseVO<>();
        int roleupdate = adminService.roleupdate(record);
        if (roleupdate==1){
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            responseVO.setData(record);
        }else {
            responseVO.setErrmsg("失败");
            responseVO.setErrno(-1);
            responseVO.setData(null);
        }
        return responseVO;
    }
    @RequestMapping("admin/delete")
    public ResponseVO<Admin> admindelete(@RequestBody Admin id){
        ResponseVO<Admin>  responseVO = new ResponseVO<>();
        int admindelete = adminService.admindelete(id);
        if (admindelete==1){
            responseVO.setErrmsg("成功");
            responseVO.setErrno(0);
            responseVO.setData(null);
        }else {
            responseVO.setErrmsg("失败");
            responseVO.setErrno(-1);
            responseVO.setData(null);
        }
        return responseVO;
    }


}