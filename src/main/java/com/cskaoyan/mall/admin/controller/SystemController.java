package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.Log;
import com.cskaoyan.mall.admin.service.LogService;
import com.cskaoyan.mall.admin.service.RoleService;
import com.cskaoyan.mall.admin.bean.Admin;
import com.cskaoyan.mall.admin.bean.Role;
import com.cskaoyan.mall.admin.bean.Storage;
import com.cskaoyan.mall.admin.service.AdminService;
import com.cskaoyan.mall.admin.service.StorageService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemController {
    @Autowired
    AdminService adminService;
    @Autowired
    RoleService roleService;
    @Autowired
    LogService logService;
    @Autowired
    StorageService storageService;


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
    public ResponseVO<PageVO> adminList(int page,int limit, String sort, String order,String username){
        PageVO<Admin> adminPageVO = adminService.findAdminPage(page,limit,username);
        ResponseVO<PageVO>  responseVO = new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        responseVO.setData(adminPageVO);
        return responseVO;
    }
    @RequestMapping("role/list")
public ResponseVO<PageVO>rolelist(int page,int limit,String sort,String order,String name){
        PageVO<Role> rolePageVO =roleService.findRolePage(page,limit,name);
        ResponseVO<PageVO> responseVO =new ResponseVO<>();
        responseVO.setErrno(0);
        responseVO.setErrmsg("成功");
        responseVO.setData(rolePageVO);
   return responseVO;
    }
    @RequestMapping("role/options")
    public ResponseVO<List> roleOptions(){
        ResponseVO<List>  responseVO = new ResponseVO<>();
        List<Role> roles = roleService.queryOption();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        responseVO.setData(roles);
        return responseVO;
    }
    @RequestMapping("admin/update")
    public ResponseVO<Admin> adminupdate(@RequestBody Admin admin){
        int roleupdate = adminService.roleupdate(admin);
        ResponseVO response = response(roleupdate,admin);
        return  response;
    }
    @RequestMapping("role/update")
    public ResponseVO<Role> roleupdate(@RequestBody Role role){
        int roleupdate1 = roleService.roleupdate(role);
        ResponseVO  responseVO = new ResponseVO<>();
        if (roleupdate1==1){
            responseVO.setData(role);
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
    @RequestMapping("storage/update")
    public ResponseVO<Storage> storageupdate(@RequestBody Storage storage){
        int storageupdate = storageService.storageupdate(storage);
        ResponseVO  responseVO = new ResponseVO<>();
        if (storageupdate==1){
            responseVO.setData(storage);
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
    private ResponseVO response(int i,Admin admin) {
        ResponseVO  responseVO = new ResponseVO<>();
        if (i==1){
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


    @RequestMapping("admin/delete")
    public ResponseVO<Admin> admindelete(@RequestBody Admin admin){
        int admindelete = adminService.admindelete(admin);
        ResponseVO response = response(admindelete,admin);
        return response;

    }
    @RequestMapping("storage/delete")
    public ResponseVO<Storage>storagedelete(@RequestBody Storage storage){
        ResponseVO  responseVO = new ResponseVO<>();
        int storagedelete = storageService.storagedelete(storage);
        if (storagedelete==1){
            responseVO.setData(storage);
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


    @RequestMapping("storage/list")
    public ResponseVO<PageVO>storagelist(int page,int limit,Storage storage){
        PageVO<Storage> StoragePageVO =storageService.findStoragePage(page,limit,storage);
        ResponseVO<PageVO> responseVO =new ResponseVO<>();
        responseVO.setErrno(0);
        responseVO.setErrmsg("成功");
        responseVO.setData(StoragePageVO);
        return responseVO;
    }
    @RequestMapping("admin/create")
    public ResponseVO<Admin> adminadd(@RequestBody Admin admin){
        int adminadd = adminService.adminadd(admin);
        ResponseVO response = response(adminadd,admin);
        return response;
    }

    @RequestMapping("log/list")
    public ResponseVO<PageVO> LogList(int page,int limit, String sort, String order,String name){
        PageVO<Log> logPageVO = logService.findLogPage(page,limit,name);
        ResponseVO<PageVO>  responseVO = new ResponseVO<>();
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        responseVO.setData(logPageVO);
        return responseVO;
    }



}
