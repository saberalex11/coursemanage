package com.ly.controller;

import com.ly.bean.SysMenuEntity;
import com.ly.service.SysMenuService;
import com.ly.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 系统菜单
 *
 * @author hanpeng
 * @date 2016年10月27日 下午9:58:15
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController{

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 用户菜单列表
	 */
	@RequestMapping("/getUserMenuList")
	public R user(){
		List<SysMenuEntity> menuList = sysMenuService.queryUserList();
		return R.ok().put("menuList", menuList);
	}

	/**
	 * 左侧用户菜单列表
	 */
	@RequestMapping("/getSubMenuList")
	public R user(@RequestParam Long parentId){
		List<SysMenuEntity> subMenuList = sysMenuService.querySubMenuList(parentId);
		return R.ok().put("subMenuList",subMenuList);
	}
}
