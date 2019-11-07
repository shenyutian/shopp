package com.syt.shopp.dao;

import com.syt.shopp.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author syt
 *
 * 用户类
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询用户
     * @param userName
     * @return
     */
    User selectByUserName(String userName);

    /**
     * 查询登录
     * @param userName
     * @param userPassword
     * @return
     */
    User selectByUserOrEmail(String userName, String userPassword);
}