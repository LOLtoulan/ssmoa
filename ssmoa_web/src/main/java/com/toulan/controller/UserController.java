package com.toulan.controller;

import com.github.pagehelper.PageInfo;
import com.toulan.domain.Role;
import com.toulan.domain.UserInfo;
import com.toulan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/1 15:12
 * @Message
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")int size){

        ModelAndView mv = new ModelAndView();

        List<UserInfo> userList = userService.finaAll(page, size);

        mv.addObject("userList", userList);

        mv.setViewName("user-list");


        return mv;
    }*/


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1", required = false) int page,
                                @RequestParam(name = "size", required = false, defaultValue = "5") int size) {

        ModelAndView mv = new ModelAndView();

        List<UserInfo> userList = userService.finaAll(page, size);

        PageInfo pageUser = new PageInfo<>(userList);

        mv.addObject("pageUser", pageUser);

        mv.setViewName("user-page-list");

        return mv;
    }

    @RequestMapping("/save.do")
    public String saveUser(UserInfo userInfo) {

        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) {

        ModelAndView mv = new ModelAndView();

        UserInfo userInfo = userService.findById(id);

        mv.addObject("user", userInfo);

        mv.setViewName("user-show");

        return mv;

    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userId) {

        ModelAndView mv = new ModelAndView();

        UserInfo userInfo = userService.findById(userId);

        List<Role> roles = userService.findOtherRoles(userId);

        mv.addObject("userInfo", userInfo);

        mv.addObject("roles", roles);

        mv.setViewName("user-role-add");

        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId" ,required=true) String userId,
                                @RequestParam(name = "ids" ,required = true) String[] roleIds) {

        userService.addRoleToUser(userId, roleIds);

        return "redirect:findAll.do";
    }
}
