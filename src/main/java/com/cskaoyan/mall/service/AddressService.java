package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.vo.PageVO;

public interface AddressService {

    PageVO<Address> findAddressPageByNameAndUserId(int page, int limit, String userId, String name, String sort, String order);

}
