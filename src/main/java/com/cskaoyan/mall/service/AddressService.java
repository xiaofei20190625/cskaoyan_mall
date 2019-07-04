package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.vo.PageVO;

public interface AddressService {


    PageVO<Address> findAddressPage(int page, int limit);

    PageVO<Address> findAddressPageByName(int page, int limit, String name);

    PageVO<Address> findAddressPageByNameAndUserId(int page, int limit, String userId, String name);

    PageVO<Address> findAddressPageByUserId(int page, int limit, String userId);
}
