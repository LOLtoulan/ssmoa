package com.toulan.dao;

import com.toulan.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/27 17:26
 * @Message
 */

public interface ProductDAO {

    /**
     * 查询所有商品信息
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll();


    /**
     * 新增商品信息
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 通过id 查询产品
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
}
