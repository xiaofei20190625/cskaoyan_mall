package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.vo.PageVO;

public interface OrderService {
    PageVO<Order> getListRecord(int page, int limit, String sort, String order, String goodsId);

}
