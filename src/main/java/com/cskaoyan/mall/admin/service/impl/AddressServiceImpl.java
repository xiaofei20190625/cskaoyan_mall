package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Address;
import com.cskaoyan.mall.admin.bean.PageList;
import com.cskaoyan.mall.admin.bean.UserVip;
import com.cskaoyan.mall.admin.mapper.AddressMapper;
import com.cskaoyan.mall.admin.service.AddressService;
import com.cskaoyan.mall.admin.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;


    @Override
    public PageVO<Address> findAddressPageByNameAndUserId(int page, int limit, String userId, String name, String sort, String order) {
        List<Address> addressPageByNameAndUserId = addressMapper.findAddressPageByNameAndUserId(userId, name,sort,order);
        PageVO<Address> addressPageVO = new PageList<Address>().pagevo(page,limit,addressPageByNameAndUserId);
        return addressPageVO;
    }
}
