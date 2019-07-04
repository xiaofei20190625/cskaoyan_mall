package com.cskaoyan.mall.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//文件上传工具类
public class FileUtils {
    public static boolean upload(MultipartFile file, String path, String fileName) {
        //最终上传的文件路径
        String realPath = path + "/" + FileNameUtils.getNewFileName(fileName);
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
