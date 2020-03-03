package com.toulan.service;

import com.toulan.domain.Role;
import com.toulan.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/29 22:37
 * @Message
 */
public interface UserService extends UserDetailsService {
    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> finaAll(int page,int size);

    /**
     * 保存用户
     * @param userInfo
     */
    void save(UserInfo userInfo);

    /**
     * 通过id查找用户信息
     * @param id
     * @return
     */
    UserInfo findById(String id);


    /**
     *
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId);

    /**
     *
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(String userId, String[] roleIds);
}
