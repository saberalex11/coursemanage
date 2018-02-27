package com.wyq.service;

import com.wyq.bean.Account;
import com.wyq.utils.R;

public interface UserInfoService extends BasicService<Account> {

    Account queryByAccount(String account);

    Account queryByAccountAndPassword(String account,String password);

    void signUp(Account account,Integer courseId);

    Account checkAdmin();

    R listAccount(String account,String name,Integer page, Integer limit);

    R listTeacherAccount(String account,String name,Integer page, Integer limit);
}
