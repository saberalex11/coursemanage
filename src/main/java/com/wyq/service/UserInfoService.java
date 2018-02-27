package com.wyq.service;

import com.wyq.bean.Account;

public interface UserInfoService extends BasicService<Account> {

    Account queryByAccount(String account);

    Account queryByAccountAndPassword(String account,String password);

    void signUp(Account account,Integer courseId);

    Account checkAdmin();
}
