package com.syt.shopp.Controller;

import com.alibaba.fastjson.JSONObject;
import com.syt.shopp.annotation.LoginRequired;
import com.syt.shopp.pojo.Cart;
import com.syt.shopp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author syt
 *
 * 购物车控制类
 */
@RestController
@LoginRequired
public class CartController {

    @Autowired
    CartService service;
    /**
     *   阿里巴巴 json类
     */
    JSONObject json = null;


    /**
     * 获得用户购物车数据，根据用户id。
     * @param id state 0失败  1成功
     * @return
     */
    @GetMapping(value = "/cart/{uid}")
    public JSONObject get(@PathVariable("uid") Integer id) {
        List<Cart> carts = service.listCat(id);
        json = new JSONObject();
        if (carts == null) {
            json.put("state", "0");
        } else {
            json.put("state", "1");
            json.put("carts", carts);
        }
        return json;
    }


    /**
     * 添加商品到购物车
     * @param map json数据
     * @return
     */
    @PostMapping(value = "/cart")
    public JSONObject add(@RequestBody Map map) {
        Cart cart = maptoCart(map);
        json = new JSONObject();
        json.put("state", service.add(cart));
        return json;
    }

    /**
     * 更新购物车
     * @param map
     * @return
     */
    @PutMapping(value = "/cart")
    public JSONObject update(@RequestBody Map map) {
        Cart cart = maptoCart(map);
        int state = service.update(cart);
        json = new JSONObject();
        json.put("state", state);
        return json;
    }

    /**
     * 删除电脑根据 id
     * @param cart
     * @return
     */
    @DeleteMapping(value = "/cart")
    public JSONObject delete(@RequestBody Cart cart) {
        int state = service.delete(cart);
        json = new JSONObject();
        json.put("state", state);
        return json;
    }

    /**
     * 对接收到的json类型map 装换为 cart类型
     * @param map
     * @return=
     */
    private static Cart maptoCart(Map map) {
        Cart cart = new Cart();
        try {
            Integer uid = (Integer) map.get("userId");
            String pid = (String) map.get("productId");
            Integer addnum = (Integer) map.get("addNum");
            String session = (String) map.get("session");
            cart.setUserId(uid);
            cart.setProductId(pid);
            cart.setAddNum(addnum);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cart参数出错！");
        }
        return cart;
    }

}
