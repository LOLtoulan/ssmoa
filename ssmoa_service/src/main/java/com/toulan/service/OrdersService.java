package com.toulan.service;

import com.toulan.domain.Orders;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/28 17:36
 * @Message
 */

public interface OrdersService {

    /**
     * 分页查询所有
     * @param page
     * @param size
     * @return
     */
    List<Orders> findAll(int page,int size);

    /**
     * 通过id查询订单信息
     * @param id
     * @return
     */
    Orders findById(String id);

    //List<Orders> findAll();
}
