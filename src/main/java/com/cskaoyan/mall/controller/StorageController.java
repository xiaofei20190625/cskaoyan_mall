package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.utils.FileNameUtils;
import com.cskaoyan.mall.utils.FileUtils;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class StorageController {

    //文件上传及回显
    //storage/create
    @RequestMapping("storage/create")
    @ResponseBody
    public ResponseVO picUpload(MultipartFile file, String filename) {
        //文件上传的文件夹
        String path = "D:\\projects\\JavaFrame\\cskaoyan_mall\\src\\main\\resources\\static\\pic";
        //文件上传成功
        if (FileUtils.upload(file, path, filename)) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = simpleDateFormat.format(date);
            String key = FileNameUtils.getNewFileName(filename);
        }
        return null;

    }
}
