package com.syt.shopp.intercept;

import com.syt.shopp.annotation.LoginRequired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;


/**
 * 自定义拦截器 判断是否登录
 * @author syt
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            // 如果不是映射到方法直接通过
            return true;
        }
        // ①:START 方法注解级拦截器
        HandlerMethod handlerMethod =  (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 获取前端发送的session id
        String mySession = (String) request.getAttribute("mySession");
        if (methodAnnotation != null) {
            System.out.println("mySession判断！");
            HttpSession session = request.getSession();
            System.out.println("user = " + session.getAttribute("user"));
            System.out.println(request.getAttributeNames());
        }
        return true;
    }
}
