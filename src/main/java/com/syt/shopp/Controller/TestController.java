package com.syt.shopp.Controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ：syt
 * @date ：Created in 2019-11-07 21:27
 * @description：测试用的类，用于测试数据是否规范
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public JSONObject getTest(@RequestBody Map str, @RequestHeader Map header) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("header", header);
        jsonObject.put("str", str);
        return jsonObject;
    }

}
