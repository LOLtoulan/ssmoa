package com.toulan.controller;

import com.github.pagehelper.PageInfo;
import com.toulan.domain.Product;
import com.toulan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/2/27 19:47
 * @Message
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查询所有商品信息
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1",required = true)int page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")int size) {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo<>(products);
        System.out.println("=======================");
        for (Product product : products) {

            System.out.println(product);
        }
        System.out.println("=======================");

        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveProduct(Product product) {
        productService.save(product);
        return "redirect:findAll.do";
    }

}
