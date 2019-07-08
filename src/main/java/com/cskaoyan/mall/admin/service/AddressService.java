package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.bean.Address;

public interface AddressService {

    PageVO<Address> findAddressPageByNameAndUserId(int page, int limit, String userId, String name, String sort, String order);

}
