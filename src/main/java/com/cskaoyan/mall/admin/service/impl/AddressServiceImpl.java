package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.AddressMapper;
import com.cskaoyan.mall.admin.mapper.RegionMapper;
import com.cskaoyan.mall.admin.service.AddressService;
import com.cskaoyan.mall.admin.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;
    @Autowired
    RegionMapper regionMapper;


    @Override
    public PageVO<Address> findAddressPageByNameAndUserId(int page, int limit, String userId, String name, String sort, String order) {
        List<Address> addressPageByNameAndUserId = addressMapper.findAddressPageByNameAndUserId(userId, name,sort,order);
        PageVO<Address> addressPageVO = new PageList<Address>().pagevo(page,limit,addressPageByNameAndUserId);
        return addressPageVO;
    }

    @Override
    public List<HashMap> addresslist(Integer userId) {
        List<Address> addresslist =addressMapper.addresslist(userId);
        ArrayList<HashMap> hashMaps = new ArrayList<>();
        for (Address address : addresslist) {
            String detailedAddress = address.getAddress();
            Boolean isDefault = address.getIsDefault();
            String mobile = address.getMobile();
            String name = address.getName();
            Integer id = address.getId();
            Integer provinceId = address.getProvinceId();
            Integer cityId = address.getCityId();
            Integer areaId = address.getAreaId();
            String province = regionMapper.queryProvince(provinceId);
            String city = regionMapper.queryCityByPid(cityId);
            String discrict = regionMapper.queryDistrictByCode(areaId);
            detailedAddress = province+city+discrict+detailedAddress;
            HashMap<Object, Object> map = new HashMap<>();

            map.put("id",id);
            map.put("detailedAddress",detailedAddress);
            map.put("isDefault",isDefault);
            map.put("mobile",mobile);
            map.put("name",name);
            hashMaps.add(map);
        }
        return hashMaps;
    }

    @Override
    public HashMap addressdetail(Integer id) {
        Address address = addressMapper.addressdetail(id);
        String detailedAddress = address.getAddress();
        Boolean isDefault = address.getIsDefault();
        String mobile = address.getMobile();
        String name = address.getName();
        Integer id1 = address.getId();
        Integer provinceId = address.getProvinceId();
        Integer cityId = address.getCityId();
        Integer areaId = address.getAreaId();
        String provinceName = regionMapper.queryProvince(provinceId);
        String cityName = regionMapper.queryCityByPid(cityId);
        String areaName = regionMapper.queryDistrictByCode(areaId);
        HashMap<Object, Object> map = new HashMap<>();

        map.put("id", id1);
        map.put("address", detailedAddress);
        map.put("isDefault", isDefault);
        map.put("mobile", mobile);
        map.put("provinceName", provinceName);
        map.put("cityName", cityName);
        map.put("areaName", areaName);
        map.put("name", name);
        return map;
    }

    @Override
    public int addressadd(Address address1) {
        int address2 = addressMapper.addressadd(address1);

        return address2;


    }


    @Override
    public List<Region> regionList(int pid) {
        List<Region> regionlist =regionMapper.regionlist(pid);


        return regionlist;
    }

    @Override
    public Address addressSearchId(Integer id) {
        Address addressSearchId = addressMapper.addressSearchId(id);
        return addressSearchId;
    }

    @Override
    public int addressUpdate(Address address1) {

        int addressUpdate = addressMapper.addressUpdate(address1);

        return addressUpdate;

    }

    @Override
    public int addressdelete(Integer id) {


        Integer address2 = addressMapper.addressdelete(id);

        return address2;
    }


}

