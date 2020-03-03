package com.toulan.service.impl;

import com.github.pagehelper.PageHelper;
import com.toulan.dao.RoleDAO;
import com.toulan.domain.Permission;
import com.toulan.domain.Role;
import com.toulan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/1 23:13
 * @Message
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Role> findAll(int page,int size) {

        PageHelper.startPage(page, size);
        return roleDAO.findAll();
    }

    @Override
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    public Role findById(String id) {

        return roleDAO.findByRoleId(id);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return roleDAO.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDAO.addRoleToUser(roleId, permissionId);
        }
    }
}
