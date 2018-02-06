package com.ly.controller;


import com.ly.bean.UserInfo;
import com.ly.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "sys/user/")
public class UserController extends BaseController  {

    @RequestMapping("info")
    public UserInfo signUp(HttpServletRequest request){
        return (UserInfo)request.getSession().getAttribute("loginUser");
    }
}
