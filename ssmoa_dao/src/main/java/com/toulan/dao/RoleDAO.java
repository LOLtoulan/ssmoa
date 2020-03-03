package com.toulan.dao;

import com.toulan.domain.Permission;
import com.toulan.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/1 0:00
 * @Message
 */
public interface RoleDAO {

    @Select("select * from role where id in( select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.toulan.dao.PermissionDAO.findById"))
    })
    public List<Role> findById(String userId);

    /**
     *
     * @return
     */
    @Select("select *from role")
    List<Role> findAll();

    /**
     *
     * @param role
     */
    @Insert("insert into role(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void save(Role role);

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from role where id =#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.toulan.dao.PermissionDAO.findById"))
    })
    public Role findByRoleId(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(String roleId);

    @Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addRoleToUser(@Param("roleId")String roleId, @Param("permissionId")String permissionId);

}
