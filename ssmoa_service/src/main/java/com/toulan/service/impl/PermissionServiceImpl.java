package com.toulan.service.impl;

import com.github.pagehelper.PageHelper;
import com.toulan.dao.PermissionDAO;
import com.toulan.domain.Permission;
import com.toulan.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/2 15:31
 * @Message
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    public List<Permission> findAll(int page,int size) {

        PageHelper.startPage(page, size);
        return permissionDAO.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDAO.save(permission);
    }
}
