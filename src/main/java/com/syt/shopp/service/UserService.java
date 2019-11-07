package com.syt.shopp.service;

import com.syt.shopp.dao.UserMapper;
import com.syt.shopp.pojo.Product;
import com.syt.shopp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author syt
 */
@Service
public class UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    /**
     * 返回根据id查询结果 用户
     * @param id
     * @return
     */
    public User getByid(Integer id) {
        User user = new User();
        Integer state;
        // 异常处理，当出现了插入失败时，将state设为0
        try {
            user = userMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            user.setUserName("0");
        }
        return user;
    }


    /**
     * 登录服务 根据用户
     * @param user
     * @return state 0用户不存在 1密码错误 2登录成功
     */
    public Integer login(User user) {
        int state = 0;
        User user1 = userMapper.selectByUserName(user.getUserName());
        if (user1 == null) {
            state = 0;
        } else if (!user.getUserPassword().equals(user1.getUserPassword())) {
            state = 1;
        } else {
            state = 2;
        }
        return state;
    }

    /**
     *  名称，邮箱 混合登录
     * @param userName
     * @param userpassword
     * @return
     */
    public Map loginByUserOrEmail(String userName, String userpassword) {
        Map data = new HashMap();
        int state = 0;
        User user = userMapper.selectByUserOrEmail(userName, userpassword);
        if (user == null) {
            state = 1;
        } else {
            state = 2;
            data.put("user", user);
        }
        data.put("state", state);
        return data;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public Integer add(User user) {
        Integer state;
        // 异常处理，当出现了插入失败时，将state设为0
        try {
            state = userMapper.insertSelective(user);
        } catch (Exception e) {
            state = 0;
        }
        return state;
    }

    /**
     * 删除用户
     * @param uid
     * @return
     */
    public Integer delete(Integer uid) {
        Integer state;
        // 异常处理，当出现了插入失败时，将state设为0
        try {
            state = userMapper.deleteByPrimaryKey(uid);
        } catch (Exception e) {
            state = 0;
        }
        return state;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public Integer update(User user) {
        Integer state = 0;
        //异常处理，当出现了插入失败时，将state设为0
        try {
            state = userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }

}
