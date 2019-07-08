package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.Log;
import com.cskaoyan.mall.admin.vo.PageVO;

public interface LogService {
    PageVO<Log> findLogPage(int page, int limit, String name);
}
