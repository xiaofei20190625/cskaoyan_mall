package com.cskaoyan.mall.admin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/29 Time 14:46
 */
public class MD5Utils {

    //计算字符串（通常为密码）的MD5
    public static String getMD5(String pwd){
        //生成一个空的字符串作为目标字符串
        String md5hashvalue = "";

        //一个长度可扩展的String
        StringBuffer stringBuffer = new StringBuffer();

        try {
            //1. 传一个参数：algorithm算法
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            //2. 传入密码，返回一个MD5字节数组（16字节，128位）
            byte[] digest = md5.digest(pwd.getBytes());

            //3. 对结果进行处理，将MD5值还原成字符串

            //从MD5字节数组中一个字节一个字节地拿出来，放入StringBuffer中
            for (byte b: digest){
                //3.1 将byte变为int，（一个字节对应一个两位的16进制数）
                int i = b & 0x000000FF;

                //3.2 int转换为16进制的字符串（将一个两位数的16进制数，转为一个字节）

                //增加盐值
                int value = 10;
                String s = Integer.toHexString(i+value);//要求传一个int

                //3.3 将每一个字节对应的字符串一次放入StringBuffer中
                if (s.length() == 1){
                    stringBuffer.append(0);
                }
                stringBuffer.append(s);
            }
            md5hashvalue = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //返回该MD5 hash值
        return md5hashvalue;
    }

    //计算文件的MD5值
    public static String getFileMD5(String filepath){
        File file = new File(filepath);
        StringBuffer stringBuffer = new StringBuffer();
        String md5hashvalue = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bs = new byte[1024];
            int len = -1;

            while((len = fileInputStream.read(bs, 0, 1024)) != -1){
                md5.update(bs, 0, len);
            }

            //文件的MD5值
            byte[] digest = md5.digest();

            for (byte b : digest){
                int i = b&0x000000FF;

                String s = Integer.toHexString(i);

                if (s.length() == 1){
                    stringBuffer.append(0);
                }
                stringBuffer.append(s);

                md5hashvalue = stringBuffer.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return md5hashvalue;
    }
}