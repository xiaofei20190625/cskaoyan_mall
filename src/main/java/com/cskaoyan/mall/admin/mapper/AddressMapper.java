package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    //int updateByPrimaryKey(Address record);

    List<Address> findAddressPageByNameAndUserId(@Param("userId") String userId,
                                                 @Param("name") String name,
                                                 @Param("sort") String sort,
                                                 @Param("order") String order);

    List addresslist(Integer userId);
    Address addressdetail(Integer id);
    int addressadd( Address address);

    Address addressSearchId(Integer id);

    int addressUpdate(Address address1);

    int addressdelete(int id);
}