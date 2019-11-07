package com.syt.shopp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author syt
 * 登录拦截器注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})// 可用在方法名上, 接口、类、枚举、注解上
@Retention(RetentionPolicy.RUNTIME)// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface LoginRequired {
    //设置返回的默认值为true
    boolean required() default true;
}
