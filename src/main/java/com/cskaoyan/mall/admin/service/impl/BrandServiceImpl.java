package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Brand;
import com.cskaoyan.mall.admin.mapper.BrandMapper;
import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
        int i = brandMapper.deleteBrandById(brand.getId());
        return i;
    }

    @Override
    public Brand createBrand(Brand brand) {
        Date date = new Date();
        brand.setSortOrder(50);
        brand.setAddTime(date);
        brand.setUpdateTime(date);
        brand.setDeleted(false);
        int i = brandMapper.insertBrand(brand);
        if (i == 1) {
            return brand;
        }
        return null;
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public Brand getBrandById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HashMap> getBrand() {
        List<Brand> brandList = brandMapper.getBrand();
        ArrayList<HashMap> hashMaps = new ArrayList<>();
        for (Brand brand : brandList) {
            String desc = brand.getDesc();
            Double floorPrice = brand.getFloorPrice();
            Integer id = brand.getId();
            String name = brand.getName();
            String picUrl = brand.getPicUrl();
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("desc", desc);
            hashMap.put("floorPrice", floorPrice);
            hashMap.put("id", id);
            hashMap.put("name", name);
            hashMap.put("picUrl", picUrl);
            hashMaps.add(hashMap);
        }
        return hashMaps;
    }
    @Override
    public List<com.cskaoyan.mall.wx.bean.Brand> getWxBrandList() {
        return brandMapper.getWxBrandList();

    }
}

