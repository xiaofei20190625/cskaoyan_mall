package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.vo.PageVO;

public interface AdService {
    PageVO<Ad> getList(int page, int limit, String sort, String order ,String  name ,String content);

    int updateById(Ad ad);

    int  delete(Ad ad);

    int create(Ad ad);
}
