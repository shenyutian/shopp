package com.syt.shopp.dao;

import com.syt.shopp.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author syt
 *
 * 订单类
 */
@Mapper
public interface OrderMapper {
    /**
     * 删除订单
     * @param orderId
     * @return
     */
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 根据 uid 查询订单
     * @param uid
     * @return
     */
    Order selectByUid(Integer uid);
}