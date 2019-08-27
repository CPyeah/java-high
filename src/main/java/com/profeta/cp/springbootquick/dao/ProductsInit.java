package com.profeta.cp.springbootquick.dao;

import com.profeta.cp.springbootquick.Entity.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * 服务启动时调用, 初始化产品数据, 模拟数据源
 * create by CP on 2019/8/27 0027.
 */
public class ProductsInit {

    public static List<Product> productsList = new ArrayList<>();

    static {
        productsList.add(new Product(1, "Yeezy500", 2189.0));
        productsList.add(new Product(2, "AirJordan1", 2699.0));
        productsList.add(new Product(3, "Kyrie5", 939.0));
        productsList.add(new Product(4, "AllStar", 699.0));
        productsList.add(new Product(5, "AirForce", 979.0));
    }
}
