package com.syt.shopp.dao;

import com.syt.shopp.pojo.Cart;
import com.syt.shopp.pojo.CartKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author syt
 *
 * 购物车类
 */
@Mapper
public interface CartMapper {

    /**
     * 删除购物车商品
     * @param key
     * @return
     */
    int deleteByPrimaryKey(CartKey key);

    /**
     * 删除购物车商品
     * @param record
     * @return
     */
    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(CartKey key);

    /**
     * 更新购物车商品
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    /**
     * 根据用户id查询购物车列表
     * @param userId
     * @return
     */
    List<Cart> selectByUserId(Integer userId);
}