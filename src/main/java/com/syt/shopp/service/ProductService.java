package com.syt.shopp.service;

import com.syt.shopp.dao.ProductMapper;
import com.syt.shopp.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author syt
 *
 * 电脑服务类
 *
 */
@Service
public class ProductService {

    @Autowired(required = false)
    ProductMapper productMapper;

    /**
     * 返回根据id查询结果
     * @param id
     * @return
     */
    public Product getByid(String id) {
        return productMapper.selectByPrimaryKey(id);
    }


    /**
     * 查询所有电脑
     * @return
     */
    public List<Product> list() {
        return productMapper.getList();
    }

    /**
     * 添加电脑
     * @param product
     * @return
     */
    public Integer add(Product product) {
        Integer state;
        // 异常处理，当出现了插入失败时，将state设为0
        try {
            state = productMapper.insert(product);
        } catch (Exception e) {
            state = 0;
        }
        return state;
    }

    /**
     * 删除电脑
     * @param proName
     * @return
     */
    public Integer delete(String proName) {
        Integer state;
        // 异常处理，当出现了插入失败时，将state设为0
        try {
            state = productMapper.deleteByPrimaryKey(proName);
        } catch (Exception e) {
            state = 0;
        }
        return state;
    }

    /**
     * 更新电脑信息
     * @param product
     * @return
     */
    public Integer update(Product product) {
        Integer state = 0;
        //异常处理，当出现了插入失败时，将state设为0
        try {
            System.out.println("product = " + product);
            state = productMapper.updateByPrimaryKeySelective(product);
        } catch (Exception e) {
            state = 0;
        }
        return state;
    }

}
