package com.toulan.service.impl;

import com.github.pagehelper.PageHelper;
import com.toulan.dao.OrdersDAO;
import com.toulan.domain.Orders;
import com.toulan.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/28 17:36
 * @Message
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDAO ordersDAO;

    /**
     * 分页查询所有
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        return ordersDAO.findAll();
    }

    /**
     * 通过id查询订单详情
     * @param id
     * @return
     */
    @Override
    public Orders findById(String id) {


        return ordersDAO.findById(id);
    }
}
