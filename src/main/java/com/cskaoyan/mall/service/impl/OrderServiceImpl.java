package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.service.OrderService;
import com.cskaoyan.mall.vo.PageVO;
import org.springframework.stereotype.Service;

/**
 * @author Alex_Cheng
 * @date 2019/7/4 23:49
 * @Description TODO
 */
@Service
public class OrderServiceImpl  implements OrderService {
    @Override
    public PageVO<Order> getListRecord(int page, int limit, String sort, String order, String goodsId) {
        return null;
    }
}
