package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Ad;

import java.util.List;

public interface AdService {
    List<Ad> selectPageAd(int page, int limit, String sort, String order);
}
