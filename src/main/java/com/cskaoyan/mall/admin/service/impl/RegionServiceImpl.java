package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Province;
import com.cskaoyan.mall.admin.mapper.RegionMapper;
import com.cskaoyan.mall.admin.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 17:04
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<Province> getAllRegion() {
        return regionMapper.queryAllProvince();
    }
}
