package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.MyOssClient;
import com.cskaoyan.mall.admin.bean.Storage;
import com.cskaoyan.mall.admin.service.StorageService;
import com.cskaoyan.mall.admin.utils.FileNameUtils;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/4 Time 15:03
 */
@Controller
@RequestMapping("admin")
public class FileController {
    @Autowired
    MyOssClient myOssClient;
    @Autowired
    StorageService storageService;
    //文件上传及回显
    //storage/create
    @RequestMapping("storage/create")
    @ResponseBody
    public ResponseVO picUpload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        ResponseVO<Storage> responseVO = null;
        //文件回显的url
        String bucket = myOssClient.getBucket();
        String endpoint = myOssClient.getEndpoint();
        String desFileName = FileNameUtils.getNewFileName(filename);
        String contentType = file.getContentType();
        String url = "https://" + bucket + "." + endpoint + "/" + desFileName;
        int i = new Long(file.getSize()).intValue();
        Integer size = Integer.valueOf(i);
        try {
            myOssClient.ossFileUpload(file, desFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date now = new Date();
        Storage storage = new Storage(desFileName, filename, contentType, size, url, now, now, false);
        int insert = storageService.insert(storage);
        if (insert == 1) {
            responseVO = new ResponseVO<>(storage, "成功", 0);

        }
        return responseVO;

    }
}
