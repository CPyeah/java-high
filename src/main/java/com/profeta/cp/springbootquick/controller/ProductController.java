package com.profeta.cp.springbootquick.controller;

import com.profeta.cp.springbootquick.Entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.profeta.cp.springbootquick.dao.ProductsInit.productsList;

/**
 * create by CP on 2019/8/27 0027.
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public Map products() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0000);
        result.put("result", productsList);
        return result;
    }

    @GetMapping("/product/{id}")
    public Map product(@PathVariable Integer id) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0000);
        productsList.forEach(item->{
            if (item.getId().equals(id)) {
                result.put("result", item);
            }
        });
        return result;
    }

    @PostMapping("/product")
    public Map product(@RequestBody Product newProduct) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0000);
        Product newest = Collections.max(productsList);
        Integer id = newest.getId() + 1;
        newProduct.setId(id);
        boolean r = productsList.add(newProduct);
        result.put("result", r);
        return result;
    }

    @PutMapping("/product/{id}")
    public Map product(@RequestBody Product product, @PathVariable Integer id) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0000);
        for (int i = 0; i < productsList.size(); i++) {
            Product item = productsList.get(i);
            if (item.getId().equals(id)) {
                product.setId(id);
                Product r = productsList.set(i, product);
                result.put("result", r);
                return result;
            }
        }
        result.put("code", 404);
        result.put("result", "this id(" + id + ") is not exist.");
        return result;
    }

    @DeleteMapping("/product/{id}")
    public Map delProduct(@PathVariable Integer id) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 0000);
        Iterator<Product> iterator = productsList.iterator();
        while (iterator.hasNext()) {
            Product item = iterator.next();
            if (item.getId().equals(id)) {
                iterator.remove();
                return result;
            }
        }
        result.put("code", 404);
        result.put("result", "this id(" + id + ") is not exist.");
        return result;
    }

}
