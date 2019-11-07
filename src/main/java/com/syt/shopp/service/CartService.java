package com.syt.shopp.service;

import com.syt.shopp.dao.CartMapper;
import com.syt.shopp.pojo.Cart;
import com.syt.shopp.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired(required = false)
    CartMapper cartDao;

    /**
     * 返回根据用户id查询购物车
     * @return
     */
    public List<Cart> listCat(Integer uid) {
        return cartDao.selectByUserId(uid);
    }

    /**
     * 添加到购物车
     * @param cart
     * @return
     */
    public Integer add(Cart cart) {
        Integer state;
        // 异常处理，当出现了插入失败时，将state设为0
        try {
            state = cartDao.insert(cart);
        } catch (Exception e) {
            state = 0;
        }
        return state;
    }

    /**
     * 删除购物车
     * @param cart
     * @return
     */
    public Integer delete(Cart cart) {
        Integer state;
        // 异常处理，当出现了插入失败时，将state设为0
        try {
            state = cartDao.deleteByPrimaryKey(cart);
        } catch (Exception e) {
            state = 0;
        }
        return state;
    }

    /**
     * 修改购物车信息
     * @param cart
     * @return
     */
    public Integer update(Cart cart) {
        Integer state = 0;
        //异常处理，当出现了插入失败时，将state设为0
        try {
            System.out.println("修改为 cart = " + cart);
            state = cartDao.updateByPrimaryKeySelective(cart);
        } catch (Exception e) {
            state = 0;
        }
        return state;
    }

}
