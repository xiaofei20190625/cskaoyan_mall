package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Ad;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface AdService {
    PageVO<Ad> getList(int page, int limit, String sort, String order ,String  name ,String content);

    int updateById(Ad ad);

    int  delete(Ad ad);

}
