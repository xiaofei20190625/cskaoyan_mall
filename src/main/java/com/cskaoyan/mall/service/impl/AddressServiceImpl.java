package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.PageList;
import com.cskaoyan.mall.bean.UserVip;
import com.cskaoyan.mall.mapper.AddressMapper;
import com.cskaoyan.mall.service.AddressService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
