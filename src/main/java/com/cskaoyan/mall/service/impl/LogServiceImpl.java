package com.cskaoyan.mall.service.impl;


import com.cskaoyan.mall.bean.Log;
import com.cskaoyan.mall.mapper.LogMapper;
import com.cskaoyan.mall.service.LogService;
import com.cskaoyan.mall.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public PageVO<Log> findLogPage(int page, int limit, String name) {
        PageHelper.startPage(page,limit);
        List<Log> logList = logMapper.findLogPage(name);
        PageInfo<Log> logPageInfo = new PageInfo<>(logList);
        PageVO<Log> logPageVO = new PageVO<>(logPageInfo.getTotal(),logPageInfo.getList());
        return logPageVO;
    }


}
