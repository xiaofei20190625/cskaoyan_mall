package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.vo.PageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> findAddressPage();

    List<Address> findAddressPageByName(String name);

    List<Address> findAddressPageByNameAndUserId(@Param("userId") int userId, @Param("name") String name);

    List<Address> findAddressPageByUserId(int userId);
}