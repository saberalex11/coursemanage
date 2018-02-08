package com.ly.controller;

import com.ly.bean.UserInfo;
import com.ly.service.UserInfoService;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "sys")
public class LoginController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("signUp")
    public R signUp(UserInfo userInfo){
        logger.info("注册开始");
        try{
            UserInfo check = userInfoService.queryByAccount(userInfo.getUserAccount());
            if(check != null){
                return R.error(-1,"账号已存在");
            }
            userInfo.setIsUse(1);
            userInfoService.addSelective(userInfo);
            logger.info("注册成功");
            return R.ok();
        }catch (Exception e){
            logger.error("注册失败",e);
            return R.error(-1,"未知错误");
        }
    }

    @RequestMapping("login")
    public R login(UserInfo userInfo, HttpServletRequest request){
        logger.info("登陆开始");
        try{
            UserInfo check = userInfoService.queryByAccountAndPassword(userInfo.getUserAccount(),userInfo.getPassword());
            if(check == null){
                return R.error(-1,"账号不存在或密码错误");
            }
            request.getSession(true).setAttribute("loginUser",check);
            request.getSession().setAttribute("result","success");
            logger.info("登陆成功");
            return R.ok();
        }catch (Exception e){
            logger.error("登陆失败",e);
            return R.error(-1,"未知错误");
        }
    }

    @RequestMapping("loginOut")
    public void loginOut(HttpServletRequest request){
        logger.info("登出");
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("result");
    }
}
