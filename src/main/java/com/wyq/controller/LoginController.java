package com.wyq.controller;

import com.wyq.bean.Account;
import com.wyq.service.UserInfoService;
import com.wyq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "sys")
public class LoginController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("signUp")
    public R signUp(Account userInfo,Integer courseId){
        logger.info("注册开始");
        try{
            if(userInfo.getAccountType() == 0){
                Account checkAdmin = userInfoService.checkAdmin();
                if(checkAdmin != null){
                    return R.error(-1,"已经存在一个管理员账号，不允许注册多个");
                }
            }
            Account check = userInfoService.queryByAccount(userInfo.getAccount());
            if(check != null){
                return R.error(-1,"账号已存在");
            }
            userInfo.setAccountStatus(1);
            userInfoService.signUp(userInfo,courseId);
            logger.info("注册成功");
            return R.ok();
        }catch (Exception e){
            logger.error("注册失败",e);
            return R.error(-1,"未知错误");
        }
    }

    @RequestMapping("login")
    public R login(Account userInfo, HttpServletRequest request){
        logger.info("登陆开始");
        try{
            Account check = userInfoService.queryByAccountAndPassword(userInfo.getAccount(),userInfo.getPassword());
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