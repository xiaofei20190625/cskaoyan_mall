package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.GoodsS;
import com.cskaoyan.mall.bean.OrderS;
import com.cskaoyan.mall.bean.UserS;
import com.cskaoyan.mall.mapper.StatisticalMapper;
import com.cskaoyan.mall.service.StatisticalService;
import com.cskaoyan.mall.vo.StatisticalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticalServiceImpl implements StatisticalService {
    @Autowired
    StatisticalMapper StatisticalMapper;

    @Override
    public StatisticalVO<UserS> queryStatistical() {
        StatisticalVO<UserS> UserSStatistical = new StatisticalVO<>();
        List<UserS> UserS = StatisticalMapper.queryUserS();
        UserSStatistical.setRows(UserS);
        List columnsUserS = new ArrayList();
        columnsUserS.add("day");
        columnsUserS.add("users");
        /*PropertyDescriptor[] props = null;
        try {
            props = Introspector.getBeanInfo(UserS.class, Object.class).getPropertyDescriptors();
            if (props != null) {
                for (int i = 0; i < props.length; i++) {
                    String aa = props[i].getName();//获取bean中的属性
                    columns.add(aa);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }*/

        UserSStatistical.setColumns(columnsUserS);
        return UserSStatistical;
    }

    @Override
    public StatisticalVO<OrderS> queryStatisticalOrder() {
        StatisticalVO<OrderS> orderSStatistical = new StatisticalVO<>();
        List<OrderS> orders = StatisticalMapper.queryOrderS();
        orderSStatistical.setRows(orders);
        List columnsOrderS =new ArrayList();
        columnsOrderS.add("day");
        columnsOrderS.add("orders");
        columnsOrderS.add("customers");
        columnsOrderS.add("amount");
        columnsOrderS.add("pcr");
        /*PropertyDescriptor[] props = null;
        try {
            props = Introspector.getBeanInfo(Orders.class, Object.class).getPropertyDescriptors();
            if (props != null) {
                for (int i = 0; i < props.length; i++) {
                    String aa = props[i].getName();//获取bean中的属性
                    columns.add(aa);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }*/

        orderSStatistical.setColumns(columnsOrderS);
        return orderSStatistical;
    }

    @Override
    public StatisticalVO<GoodsS> queryStatisticalGoods() {
        StatisticalVO<GoodsS> goodsSStatistical = new StatisticalVO<>();
        List<GoodsS> goodsS = StatisticalMapper.queryGoodsS();
        goodsSStatistical.setRows(goodsS);
        List columnsOrderS =new ArrayList();
        columnsOrderS.add("day");
        columnsOrderS.add("orders");
        columnsOrderS.add("products");
        columnsOrderS.add("amount");
        goodsSStatistical.setColumns(columnsOrderS);
        return goodsSStatistical;
    }
}
