package com.wyq.controller;

import com.wyq.bean.Account;
import com.wyq.bean.SysMenuEntity;
import com.wyq.service.SysMenuService;
import com.wyq.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
	public R user(HttpServletRequest request){
		List<SysMenuEntity> menuList = sysMenuService.queryUserList();
		return R.ok().put("menuList", menuList);
	}

	/**
	 * 左侧用户菜单列表
	 */
	@RequestMapping("/getSubMenuList")
	public R user(@RequestParam Long parentId,HttpServletRequest request){
		List<SysMenuEntity> subMenuList = sysMenuService.querySubMenuList(parentId);
		List<SysMenuEntity> menuResultList = null;
		Account current = (Account)request.getSession().getAttribute("loginUser");
		if(current.getAccountType() == 0){
			menuResultList = subMenuList.parallelStream().filter(p -> StringUtils.isBlank(p.getPerms())
					|| StringUtils.equals(p.getPerms(),"perm:admin")).collect(Collectors.toList());
		}else if(current.getAccountType() == 1){
			menuResultList = subMenuList.parallelStream().filter(p -> StringUtils.isBlank(p.getPerms())
					|| StringUtils.equals(p.getPerms(),"perm:teacher")).collect(Collectors.toList());
		}else if(current.getAccountType() == 2){
			menuResultList = subMenuList.parallelStream().filter(p -> StringUtils.isBlank(p.getPerms())
					|| StringUtils.equals(p.getPerms(),"perm:student")).collect(Collectors.toList());
		}
		return R.ok().put("subMenuList",menuResultList);
	}
}
