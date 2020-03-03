package com.toulan.controller;

import com.github.pagehelper.PageInfo;
import com.toulan.domain.Orders;
import com.toulan.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/28 17:40
 * @Message
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    public OrdersService ordersService;

    /*@RequestMapping("/findAll.do")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView();

        List<Orders> ordersList = ordersService.findAll();

        mv.addObject("ordersList", ordersList);

        mv.setViewName("orders-list");

        return mv;
    }*/

    /**
     * 分页查询数据
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")int size) {

        ModelAndView mv = new ModelAndView();

        List<Orders> ordersList = ordersService.findAll(page,size);

        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);

        mv.addObject("pageInfo", pageInfo);

        mv.setViewName("orders-page-list");

        return mv;
    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) {
        ModelAndView mv = new ModelAndView();

        Orders orders = ordersService.findById(id);

        mv.addObject("orders",orders);

        mv.setViewName("orders-show");

        return mv;
    }

}
