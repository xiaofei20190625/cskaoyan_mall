package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.GoodsS;
import com.cskaoyan.mall.bean.OrderS;
import com.cskaoyan.mall.bean.UserS;
import com.cskaoyan.mall.vo.StatisticalVO;

public interface StatisticalService {
    StatisticalVO<UserS> queryStatistical();

    StatisticalVO<OrderS> queryStatisticalOrder();

    StatisticalVO<GoodsS> queryStatisticalGoods();
}
