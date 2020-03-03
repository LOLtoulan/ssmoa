package com.toulan.dao;

import com.toulan.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/29 10:07
 * @Message
 */
public interface TravellerDAO {

    @Select("select *from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId);
}
