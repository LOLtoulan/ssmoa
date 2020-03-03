package com.toulan.service;

import com.toulan.domain.Product;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/27 17:29
 * @Message
 */
public interface ProductService {

    /**
     * 查询所有商品
     * @return
     */
    List<Product> findAll(int page,int size);

    /**
     * 新增商品信息
     * @param product
     */
    void save(Product product);

    /**
     * 通过 id 查询产品
     * @param id
     * @return
     * @throws Exception
     */
    Product findById(String id) throws Exception;
}
