package com.toulan.controller;

import com.github.pagehelper.PageInfo;
import com.toulan.domain.Permission;
import com.toulan.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/2 15:28
 * @Message
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")int size) {

        ModelAndView mv = new ModelAndView();

        List<Permission> permissions = permissionService.findAll(page,size);

        PageInfo pagePermission = new PageInfo<>(permissions);

        mv.addObject("pagePermission", pagePermission);

        mv.setViewName("permission-list");

        return mv;

    }

    @RequestMapping("/save.do")
    public String savePermission(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

}
