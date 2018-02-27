package com.wyq.service;

import com.wyq.bean.SysMenuEntity;
import com.wyq.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;


@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuMapper sysMenuDao;

    /**
     * 获取用户权限下的所有一级菜单
     * @date 2017-09-23 23:22
     * @author hanp
     */
    @Override
    public List<SysMenuEntity> queryUserList() {
        return queryListParentId(0L);
    }
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @author hanp
     * @date 2017-09-23 23:30
     */
    @Override
    public List<SysMenuEntity> querySubMenuList(Long parentId) {

        //二级菜单
        List<SysMenuEntity> list = this.queryByParentIdAndUserId(parentId);

        if(null != list && !list.isEmpty()){

            List<SysMenuEntity> subMenuList = new ArrayList<>();

            for (SysMenuEntity menu : list) {
                SysMenuEntity subMenu = new SysMenuEntity();
                subMenu.setName(menu.getName());
                subMenu.setIcon(menu.getIcon());
                subMenu.setUrl(menu.getUrl());
                subMenu.setPerms(menu.getPerms());
                subMenuList.add(subMenu);

            }
            return subMenuList;

        }
        return null;
    }
    private List<SysMenuEntity> queryByParentIdAndUserId( Long parentId) {
        return queryListParentId(parentId);
    }
    public List<SysMenuEntity> queryListParentId(Long parentId) {

        Example ex = new Example(SysMenuEntity.class);
        ex.createCriteria().andCondition("parent_id="+parentId)
                .andCondition(" TYPE = 1 AND status = 1");
        return sysMenuDao.selectByExample(ex);
    }

}
