package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.service.OrderService;
import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.vo.PageVO;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl  implements OrderService {
    @Override
    public PageVO<Order> getListRecord(int page, int limit, String sort, String order, String goodsId) {
        return null;
    }

}
