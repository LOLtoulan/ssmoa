package com.toulan.service.impl;

import com.github.pagehelper.PageHelper;
import com.toulan.dao.ProductDAO;
import com.toulan.domain.Product;
import com.toulan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/27 17:30
 * @Message
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO produceDAo;

    @Override
    public List<Product> findAll(int page,int size) {

        PageHelper.startPage(page, size);
        return produceDAo.findAll();
    }

    @Override
    public void save(Product product) {
        produceDAo.save(product);
    }

    @Override
    public Product findById(String id) throws Exception {

        return  produceDAo.findById(id);
    }
}
