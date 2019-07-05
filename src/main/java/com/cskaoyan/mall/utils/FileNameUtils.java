package com.cskaoyan.mall.utils;

public class FileNameUtils {
    /**
     *获取文件后缀
     */
    public static String getSuffix(String fileName) {

        return fileName.substring(fileName.lastIndexOf("."));
    }

    //获取新的文件名
    public static String getNewFileName(String fileOriginName) {
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }

}
