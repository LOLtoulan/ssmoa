package com.toulan.service.impl;

import com.github.pagehelper.PageHelper;
import com.toulan.dao.UserDAO;
import com.toulan.domain.Role;
import com.toulan.domain.UserInfo;
import com.toulan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author LOL_toulan
 * @Time 2020/2/29 22:42
 * @Message
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDAO.findByUsername(username);

        return new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Role r : roles) {

            list.add(new SimpleGrantedAuthority("ROLE_" + r.getRoleName()));
        }

        return list;
    }

    @Override
    public List<UserInfo> finaAll(int page, int size) {

        PageHelper.startPage(page, size);
        return userDAO.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {

        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));

        userDAO.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {

        return userDAO.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(String userId) {

        List<Role> roles = userDAO.findOtherRoles(userId);

        return roles;
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {

        for (String roleId : roleIds) {
            userDAO.addRoleToUser(userId, roleId);
        }
    }
}
