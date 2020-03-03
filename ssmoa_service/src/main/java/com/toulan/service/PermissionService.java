package com.toulan.service;

import com.toulan.domain.Permission;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/2 15:30
 * @Message
 */
public interface PermissionService {


    List<Permission> findAll(int page,int size);

    void save(Permission permission);
}
