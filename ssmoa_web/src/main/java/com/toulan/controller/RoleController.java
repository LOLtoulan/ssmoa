package com.toulan.controller;

import com.github.pagehelper.PageInfo;
import com.toulan.domain.Permission;
import com.toulan.domain.Role;
import com.toulan.domain.UserInfo;
import com.toulan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/1 23:09
 * @Message
 */
@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public  ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                                 @RequestParam(name = "size",required = true,defaultValue = "5")int size){

        ModelAndView mv = new ModelAndView();

        List<Role> all = roleService.findAll(page,size);

        PageInfo pageRole = new PageInfo<>(all);

        mv.addObject("pageRole", pageRole);

        mv.setViewName("role-list");

        return mv;
    }

    @RequestMapping("/save.do")
    public String saveUser(Role role) {

        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){

        ModelAndView mv = new ModelAndView();

        Role role = roleService.findById(id);

        mv.addObject("role", role);

        mv.setViewName("role-show");

        return mv;

    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId){

        ModelAndView mv = new ModelAndView();

        Role role = roleService.findById(roleId);

        List<Permission> permissions = roleService.findOtherPermission(roleId);

        mv.addObject("role", role);

        mv.addObject("permissions", permissions);

        mv.setViewName("role-permission-add");

        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addRoleToUser(@RequestParam(name = "roleId" ,required=true) String roleId,
                                @RequestParam(name = "id" ,required = true) String[] permissionIds) {

        roleService.addPermissionToRole(roleId, permissionIds);

        return "redirect:findAll.do";
    }
}
