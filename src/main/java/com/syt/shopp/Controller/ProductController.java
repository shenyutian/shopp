package com.syt.shopp.Controller;

import com.alibaba.fastjson.JSONObject;
import com.syt.shopp.pojo.Product;
import com.syt.shopp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author syt
 * 电脑控制类
 */
@RestController
public class ProductController {

    @Autowired
    ProductService service;
    /**
     *   阿里巴巴 json类
     */
    JSONObject json = null;


    /**
     * 获得电脑数据，根据id。
     * @param id
     * @return
     */
    @GetMapping(value = "/product/{id}")
    public JSONObject get(@PathVariable("id") String id) {
        Product product = service.getByid(id);
        json = new JSONObject();
        if (product == null) {
            json.put("state", "404");
        } else {
            json.put("state", "200");
            json.put("product", product);
        }
        return json;
    }

    /**
     * 获得所有电脑信息
     * @return
     */
    @GetMapping(value = "/products")
    public JSONObject list() {
        List<Product> productList = service.list();
        json = new JSONObject();
        if (productList == null) {
            json.put("state", "404");
        } else {
            json.put("state", "3");
            json.put("products", productList);
        }
        return json;
    }

    /**
     * 添加电脑
     * @param product
     * @return
     */
    @PostMapping(value = "/product")
    public JSONObject add(@RequestBody Product product) {
        System.out.println("product = " + product);
        int state = service.add(product);
        json = new JSONObject();
        json.put("state", state);
        return json;
    }

    /**
     * 更新电脑
     * @param product
     * @return
     */
    @PutMapping(value = "/product")
    public JSONObject update(@RequestBody Product product) {
        System.out.println("product = " + product);
        int state = service.update(product);
        json = new JSONObject();
        json.put("state", state);
        return json;
    }

    /**
     * 删除电脑根据 id
     * @param proName
     * @return
     */
    @DeleteMapping(value = "/product/{id}")
    public JSONObject delete(@PathVariable("id") String proName) {
        int state = service.delete(proName);
        json = new JSONObject();
        json.put("state", state);
        return json;
    }

}
