package com.ly.service;

import com.ly.bean.SalesMan;
import com.ly.utils.R;

public interface SalesManService extends BasicService<SalesMan> {
    R querySalesMan(String chineseName, Integer page, Integer limit);
}
