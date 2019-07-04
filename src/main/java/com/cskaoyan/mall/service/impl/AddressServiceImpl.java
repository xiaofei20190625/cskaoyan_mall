package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.UserVip;
import com.cskaoyan.mall.mapper.AddressMapper;
import com.cskaoyan.mall.service.AddressService;
import com.cskaoyan.mall.utils.PageUtil;
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
    public PageVO<Address> findAddressPage(int page, int limit) {
        List<Address> addressPage = addressMapper.findAddressPage();
        PageVO<Address> addressPageVO = new PageUtil<Address>().pagevo(page,limit,addressPage);
        return addressPageVO;
    }

    @Override
    public PageVO<Address> findAddressPageByName(int page, int limit, String name) {
        PageHelper.startPage(page,limit);
        List<Address> addressPageByName = addressMapper.findAddressPageByName(name);
        PageVO<Address> addressPageVO = new PageUtil<Address>().pagevo(page,limit,addressPageByName);
        return addressPageVO;
    }

    @Override
    public PageVO<Address> findAddressPageByNameAndUserId(int page, int limit, String userId, String name) {
        int userId1 = Integer.parseInt(userId);
        List<Address> addressPageByNameAndUserId = addressMapper.findAddressPageByNameAndUserId(userId1, name);
        PageVO<Address> addressPageVO = new PageUtil<Address>().pagevo(page,limit,addressPageByNameAndUserId);
        return addressPageVO;
    }

    @Override
    public PageVO<Address> findAddressPageByUserId(int page, int limit, String userId) {
        int userId1 = Integer.parseInt(userId);
        List<Address> addressPageByUserId = addressMapper.findAddressPageByUserId(userId1);
        PageVO<Address> addressPageVO = new PageUtil<Address>().pagevo(page,limit,addressPageByUserId);
        return addressPageVO;
    }

}
