package com.wyq.service;



import com.wyq.bean.SysMenuEntity;

import java.util.List;


/**
 * 菜单管理
 *
 * @author hanpeng
 * @date 2016年9月18日 上午9:42:16
 */
public interface SysMenuService {

	/**
	 * 查询用户的权限列表
	 */
	List<SysMenuEntity> queryUserList();

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @author hanp
	 * @date 2017-09-23 23:30
	 */
	List<SysMenuEntity> querySubMenuList( Long parentId);
}
