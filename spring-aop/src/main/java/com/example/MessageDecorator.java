package com.example;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("Hello ");
        Object value = invocation.proceed();
        // System.out.println(value); // returned value from methods
        System.out.println("!");

        return value;
    }
}
