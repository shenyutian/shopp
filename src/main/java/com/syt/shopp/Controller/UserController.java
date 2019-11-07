package com.syt.shopp.Controller;

import com.alibaba.fastjson.JSONObject;
import com.syt.shopp.pojo.Cart;
import com.syt.shopp.pojo.User;
import com.syt.shopp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService service;
    JSONObject json = null;

    /**
     * 登录功能
     * @param user
     * @return
     */
    @PostMapping(value = "/user/login")
    public JSONObject login(HttpSession session, @RequestBody User user) {
        json = new JSONObject();
        Integer state = 0;
        // 判断用户是否登录
        User user1 = (User) session.getAttribute("user");
//        System.out.println("user1 = " + user1);
        if (user1 != null && user1.equals(user)) {
            // 代表已经登录了
            state = 3;
        } else {
            // 登录成功，提取user数据，和状态码state=2
            Map data = service.loginByUserOrEmail(user.getUserName(), user.getUserPassword());
            state = (Integer) data.get("state");
            user = (User) data.get("user");
            System.out.println("data = " + data);
        }
        json.put("state", state);
        // 保存到session中
        if (state == 2) {
            session.setAttribute("user", user);
            json.put("session", session.getId());
            json.put("user", user);
        }
        return json;
    }

    /**
     * 获取用户 根据名称
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{uid}")
    public JSONObject get(@PathVariable("uid") Integer id) {
        json = new JSONObject();
        Integer state = 0;
        User user = service.getByid(id);
        if (user != null) {
            state = 1;
            json.put("user", user);
        }
        json.put("state", state);
        return json;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping(value = "/user")
    public JSONObject update(@RequestBody User user) {
        json = new JSONObject();
        Integer state = 0;
        System.out.println("user = " + user);
        json.put("state", service.update(user));
        return json;
    }

    /**
     * 添加用户，注册用
     * @param user json数据
     * @return
     */
    @PostMapping(value = "/user")
    public JSONObject add(@RequestBody User user) {
        json = new JSONObject();
        json.put("state", service.add(user));
        return json;
    }

    /**
     * 删除用户根据 id
     * @param uid
     * @return
     */
    @DeleteMapping(value = "/user/{uid}")
    public JSONObject delete(@PathVariable String uid) {
        int state = service.delete(Integer.parseInt(uid));
        json = new JSONObject();
        json.put("state", state);
        return json;
    }

    /**
     * 对接收到的json类型map 装换为 user类型
     * @param map
     * @return
     */
    private static User maptoUser(Map map) {
        User user = new User();
        try {
            Integer uid = (Integer) map.get("userId");
            user.setUserId(uid);
            String userName = (String) map.get("userName");
            user.setUserName(userName);
            String userPassword = (String) map.get("userPassword");
            user.setUserPassword(userPassword);
            String sex = (String) map.get("sex");
            user.setSex(sex);
            Integer age = (Integer) map.get("age");
            user.setAge(age);
            String phoneNum = (String) map.get("phoneNum");
            user.setPhoneNum(phoneNum);
            String email = (String) map.get("email");
            user.setEmail(email);
            String address = (String) map.get("address");
            user.setAddress(address);
            Integer points = (Integer) map.get("points");
            user.setPoints(points);
            Integer identity = (Integer) map.get("identity");
            user.setIdentity(identity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("User参数出错！");
        }
        return user;
    }

}
