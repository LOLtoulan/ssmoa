package com.toulan.dao;

import com.toulan.domain.Orders;
import com.toulan.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/28 17:19
 * @Message
 */
public interface OrdersDAO {

    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select =
                    "com.toulan.dao.ProductDAO.findById"))
    })
    List<Orders> findAll();

    /**
     * 通过id查询订单详情
     * @return
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select =
                    "com.toulan.dao.ProductDAO.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select =
                    "com.toulan.dao.TravellerDAO.findByOrdersId")),
            @Result(column = "memberId" ,property = "member",one = @One(select = "com.toulan.dao.MemberDAO.findById"))
    })
    Orders findById(String id);
}
