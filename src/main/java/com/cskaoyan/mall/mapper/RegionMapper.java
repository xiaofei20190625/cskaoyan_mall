package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 17:00
 */
public interface RegionMapper {
    List<Province> queryAllProvince();
}
