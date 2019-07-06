package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Log;
import com.cskaoyan.mall.vo.PageVO;

public interface LogService {
    PageVO<Log> findLogPage(int page, int limit, String name);
}
