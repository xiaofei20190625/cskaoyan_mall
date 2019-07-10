package com.cskaoyan.mall.wx.bean;

import com.cskaoyan.mall.admin.bean.Groupon;
import com.cskaoyan.mall.admin.bean.GrouponRules;

/**
 * @author Alex_Cheng
 * @date 2019/7/9 23:03
 * @Description TODO
 */
public class GrouponMy {
    int actualPrice;

    String creator;

    String[] goodsList;

    Groupon groupon;

    HandleOption handleOption;

    int id ;

    Boolean isCreator;

    int joinerCount ;

    int orderId;

    String orderSn;

    String orderStatusText;

    GrouponRules rules;
}
