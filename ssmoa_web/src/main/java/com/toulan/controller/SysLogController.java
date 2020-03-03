package com.toulan.controller;

import com.github.pagehelper.PageInfo;
import com.toulan.domain.SysLog;
import com.toulan.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/3/3 15:21
 * @Message
 */
@Controller
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1", required = true) int page,
                                @RequestParam(name = "size", required = true, defaultValue = "20") int size) {
        ModelAndView mv = new ModelAndView();

        List<SysLog> sysLogs = sysLogService.findAll(page, size);

        PageInfo pageSysLogs = new PageInfo(sysLogs);

        mv.addObject("pageSysLogs", pageSysLogs);

        mv.setViewName("syslog-list");

        return mv;
    }

}
