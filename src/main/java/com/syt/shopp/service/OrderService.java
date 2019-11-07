package com.syt.shopp.service;

import com.syt.shopp.dao.OrderMapper;
import com.syt.shopp.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired(required = false)
    OrderMapper orderMapper;

    /**
     * 返回查询结果订单
     * @param uid
     * @return
     */
    public Order getOrderMapper(Integer uid) {
        return orderMapper.selectByUid(uid);
    }

    /**
     * 根据 订单id 删除订单
     * @param orderId
     * @return
     */
    public Integer deleteOrderByOrderId(String orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }



}
