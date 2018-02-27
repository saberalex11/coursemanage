package com.wyq.controller;


import com.wyq.bean.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "sys/user/")
public class UserController extends BaseController  {

    @RequestMapping("info")
    public Account signUp(HttpServletRequest request){
        return (Account)request.getSession().getAttribute("loginUser");
    }
}
