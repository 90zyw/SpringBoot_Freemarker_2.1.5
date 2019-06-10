/*
 * @(#)  RoleMenuVo.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.project.service.impl;

import com.cto.project.dao.RoleMenuMapper;
import com.cto.project.entity.RoleMenu;
import com.cto.project.service.RoleMenuService;
import com.cto.project.service.base.BaseServiceImpl;
import com.cto.project.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名 RoleMenuServiceImpl.java 
 * 
 * @author 1
 * @date 2019-06-05 10:16:11
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Override
    public RoleMenuMapper getNameSpace() {
        return roleMenuMapper;
    }

    @Override
    public Page<RoleMenu> selectPage(RoleMenu roleMenu) {
        Page<RoleMenu> page = new Page<>(roleMenuMapper.selectPageCount(roleMenu), roleMenu.getPageSize(), roleMenu.getPageNum());
        List<RoleMenu> result = roleMenuMapper.selectPageList(roleMenu);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public void deleteByRoleId(Long id) {
        roleMenuMapper.deleteByRoleId(id);
    }
}