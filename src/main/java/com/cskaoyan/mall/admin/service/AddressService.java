package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.Region;
import com.cskaoyan.mall.admin.vo.PageVO;

import java.util.HashMap;
import java.util.List;

public interface AddressService {

    PageVO<Address> findAddressPageByNameAndUserId(int page, int limit, String userId, String name, String sort, String order);

    List<HashMap> addresslist(Integer userId);

    HashMap addressdetail(Integer id);

    int addressadd(Address address);

    List<Region> regionList(int pid);

    Address addressSearchId(Integer id);

    int addressUpdate(Address address1);
}
