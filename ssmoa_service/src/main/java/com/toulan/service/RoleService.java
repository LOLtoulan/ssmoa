package com.toulan.service;

import com.toulan.domain.Permission;
import com.toulan.domain.Role;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/1 23:13
 * @Message
 */
public interface RoleService {
    /**
     *
     * @return
     */
    List<Role> findAll(int page,int size);

    /**
     *
     * @param role
     */
    void save(Role role);

    /**
     *
     * @param id
     * @return
     */
    Role findById(String id);

    /**
     *
     * @param roleId
     * @return
     */
    List<Permission> findOtherPermission(String roleId);

    /**
     *
     * @param roleId
     * @param permissionIds
     */
    void addPermissionToRole(String roleId, String[] permissionIds);
}
