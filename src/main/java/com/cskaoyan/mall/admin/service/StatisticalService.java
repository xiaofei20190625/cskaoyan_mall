package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.GoodsS;
import com.cskaoyan.mall.admin.bean.OrderS;
import com.cskaoyan.mall.admin.bean.UserS;
import com.cskaoyan.mall.admin.vo.StatisticalVO;

public interface StatisticalService {
    StatisticalVO<UserS> queryStatistical();

    StatisticalVO<OrderS> queryStatisticalOrder();

    StatisticalVO<GoodsS> queryStatisticalGoods();
}
