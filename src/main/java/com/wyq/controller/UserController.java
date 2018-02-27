package com.wyq.controller;


import com.wyq.bean.Account;
import com.wyq.service.UserInfoService;
import com.wyq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "sys/user/")
public class UserController extends BaseController  {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("info")
    public Account signUp(HttpServletRequest request){
        return (Account)request.getSession().getAttribute("loginUser");
    }

    /**
     * 查询所有账号
     * @param account
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("listAccount")
    public R listAccount(String account,String name,Integer page, Integer limit){
        return userInfoService.listAccount(account,name,page,limit);
    }

    /**
     * 删除账号
     * @param account
     * @return
     */
    @RequestMapping("deleteAccount")
    public R deleteAccount(Account account){
         userInfoService.updateByPrimaryKey(account);
         return R.ok();
    }

    /**
     * 修改账号信息，只允许修改名字
     * @param account
     * @return
     */
    @RequestMapping("updateAccount")
    public R updateAccount(Account account){
        userInfoService.updateByPrimaryKeySelective(account);
        return R.ok();
    }

    /**
     * 重置密码
     * @param account
     * @return
     */
    @RequestMapping("resetPassword")
    public R resetPassword(Account account){
        userInfoService.updateByPrimaryKeySelective(account);
        return R.ok();
    }

    /**
     * 查询老师账号
     * @param account
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("listTeacherAccount")
    public R listTeacherAccount(String account,String name,Integer page, Integer limit){
        return userInfoService.listTeacherAccount(account,name,page,limit);
    }

}
