package com.ly.service;

import com.ly.bean.UserInfo;

public interface UserInfoService extends BasicService<UserInfo> {

    UserInfo queryByAccount(String account);

    UserInfo queryByAccountAndPassword(String account,String password);
}
