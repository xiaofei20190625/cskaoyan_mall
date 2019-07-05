package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.mapper.BrandMapper;
import com.cskaoyan.mall.service.BrandService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 22:13
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageVO<Brand> getPageBrand(int page, int limit, String sort, String order, String id, String name) {
        PageHelper.startPage(page, limit);
        List<Brand> brands = brandMapper.queryPageBrand(sort, order, id, name);
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        PageVO<Brand> pageVO = new PageVO<>(pageInfo.getTotal(), pageInfo.getList());
        return pageVO;
    }

    @Override
    public int deleteBrandById(Brand brand) {
        return brandMapper.deleteBrandById(brand.getId());
    }

    @Override
    public int createBrand(Brand brand) {
        return 0;
    }
}
