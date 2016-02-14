package com.example;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "writeHome".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz == MessageWriter.class;
    }
}
