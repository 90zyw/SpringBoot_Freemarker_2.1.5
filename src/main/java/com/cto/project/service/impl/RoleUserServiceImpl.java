/*
 * @(#)  RoleUserVo.java    2019-06-05 10:16:11
 * Project  :Spring boot 代码生产系统
 * Company  :http://www.594cto.com
 */
package com.cto.project.service.impl;

import com.cto.project.dao.RoleUserMapper;
import com.cto.project.entity.RoleUser;
import com.cto.project.service.RoleUserService;
import com.cto.project.service.base.BaseServiceImpl;
import com.cto.project.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名 RoleUserServiceImpl.java 
 * 
 * @author 1
 * @date 2019-06-05 10:16:11
 */
@Service
public class RoleUserServiceImpl extends BaseServiceImpl<RoleUser> implements RoleUserService {
    @Autowired
    private RoleUserMapper roleUserMapper;
    @Override
    public RoleUserMapper getNameSpace() {
        return roleUserMapper;
    }

    @Override
    public Page<RoleUser> selectPage(RoleUser roleUser) {
        Page<RoleUser> page = new Page<>(roleUserMapper.selectPageCount(roleUser), roleUser.getPageSize(), roleUser.getPageNum());
        List<RoleUser> result = roleUserMapper.selectPageList(roleUser);
        page.setRows(result == null ? new ArrayList<>() : result);
        return page;
    }

    @Override
    public void deleteByUserId(Long id) {
        roleUserMapper.deleteByUserId(id);
    }
}