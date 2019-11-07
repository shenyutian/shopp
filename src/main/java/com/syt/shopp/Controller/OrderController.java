package com.syt.shopp.Controller;

import com.alibaba.fastjson.JSONObject;
import com.syt.shopp.pojo.Order;
import com.syt.shopp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author syt
 */
@RestController
public class OrderController {

    @Autowired
    OrderService service;

    /**
     * 返回查询结果订单
     * @param uid
     * @return
     */
    @GetMapping("/order/{uid}")
    public JSONObject getOrderMapper(@PathVariable String uid) {
        JSONObject json = new JSONObject();
        json.put("state", 3);
        json.put("orders", service.getOrderMapper(Integer.parseInt(uid)));
        return json;
    }

}
