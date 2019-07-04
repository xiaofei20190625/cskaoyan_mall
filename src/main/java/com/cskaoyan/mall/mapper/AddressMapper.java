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

    List<Address> findAddressPageByNameAndUserId(@Param("userId") String userId,
                                                 @Param("name") String name,
                                                 @Param("sort") String sort,
                                                 @Param("order") String order);

}