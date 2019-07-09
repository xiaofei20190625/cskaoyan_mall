package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.Ad;

import com.cskaoyan.mall.admin.mapper.AdMapper;
import com.cskaoyan.mall.admin.service.AdService;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/7/3 23:47
 * @Description TODO
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    AdMapper adMapper ;

    @Override
    public PageVO<Ad> getList(int page, int limit, String sort, String order,String  name ,String content) {
        PageHelper.startPage(page, limit);
        List<Ad> adList = adMapper.getList(sort , order ,name , content);
        PageInfo<Ad> adPageInfo = new PageInfo<>(adList);
        PageVO<Ad> adPageVO = new PageVO<>(adPageInfo.getTotal(),adPageInfo.getList());
        return  adPageVO ;
    }

    @Override
    public int updateById(Ad ad) {
        return  adMapper.updateByPrimaryKeySelective(ad);
    }

    @Override
    public int delete(Ad ad) {
        return adMapper.deleteByPrimaryKey(ad.getId());
    }

    @Override
    public int create(Ad ad) {
        return adMapper.create(ad);
    }

    @Override
    public List<Ad> getWxBannerList() {
        return adMapper.getWxBannerList();
    }

}
