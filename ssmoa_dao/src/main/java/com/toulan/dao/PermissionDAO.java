package com.toulan.dao;

import com.toulan.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/1 20:50
 * @Message
 */
public interface PermissionDAO {

    /**
     * @param id
     * @return
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findById(String id);

    /**
     *
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAll();

    /**
     *
     * @param permission
     */
    @Insert("INSERT INTO permission (permissionName,url) VALUES (#{permissionName},#{url}) ")
    void save(Permission permission);
}
