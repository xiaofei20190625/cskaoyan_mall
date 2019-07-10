package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 17:00
 */
public interface RegionMapper {
    List<Province> queryAllProvince();
    String queryProvince(@Param("provinceId") Integer provinceId);
    String queryCityByPid(@Param("cityId") Integer cityId );
    String queryDistrictByCode(@Param("areaId") Integer areaId);

    List<Region> regionlist(int pid);
}


