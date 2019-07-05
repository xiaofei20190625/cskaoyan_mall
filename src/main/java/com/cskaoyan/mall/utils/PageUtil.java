package com.cskaoyan.mall.utils;

import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtil<T> {

    public  PageVO<T> pagevo(int page, int limit, List<T> pageList) {
        PageHelper.startPage(page,limit);
        PageInfo<T> pageInfo = new PageInfo<>(pageList);
        PageVO<T> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        return pageVO;
    }
}
