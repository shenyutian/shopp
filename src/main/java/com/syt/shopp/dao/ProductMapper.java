package com.syt.shopp.dao;

import com.syt.shopp.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author syt
 *
 * 电脑类
 */
@Mapper
public interface ProductMapper {

    /**
     * 删除电脑
     * @param productId
     * @return
     */
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    /**
     * 添加电脑
     * @param record
     * @return
     */
    int insertSelective(Product record);

    /**
     * 获得所有电脑信息
     * @param productId
     * @return
     */
    Product selectByPrimaryKey(String productId);

    /**
     * 更新电脑信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Product selectById(String productId);

    /**
     * 获得所有电脑信息
     * @return
     */
    List<Product> getList();
}