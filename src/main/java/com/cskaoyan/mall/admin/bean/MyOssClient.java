package com.cskaoyan.mall.admin.bean;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@ConfigurationProperties(prefix = "myoss")
@Component
public class MyOssClient {
    String bucket;
    String endpoint;
    String accessKey;
    String secret;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void ossFileUpload(MultipartFile myfile, String desFileName) throws IOException {
        InputStream inputStream = myfile.getInputStream();
        long size = myfile.getSize();
        String contentType = myfile.getContentType();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(size);
        objectMetadata.setContentType(contentType);

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, desFileName, inputStream, objectMetadata);
        OSSClient ossClient = new OSSClient(endpoint, accessKey, secret);
        ossClient.putObject(putObjectRequest);

    }
}
