package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.service.AdService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/3 23:47
 * @Description TODO
 */
@Service
public class AdServiceImpl implements AdService {
    @Override
    public List<Ad> selectPageAd(int page, int limit, String sort, String order) {
        return null;
    }
}
