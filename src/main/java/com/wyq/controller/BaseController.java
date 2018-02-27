package com.wyq.controller;

import com.wyq.bean.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected Account getCurrent(HttpServletRequest request){
        Account current = (Account)request.getSession().getAttribute("loginUser");
        return current;
    }
}
