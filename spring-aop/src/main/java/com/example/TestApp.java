package com.example;

import org.springframework.aop.framework.ProxyFactory;

public class TestApp {

    public static void main(final String[] args) throws Exception {

        MessageWriter target = new MessageWriter();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageDecorator());
        proxyFactory.setTarget(target);

        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();

        System.out.println("\n\nNo proxy:");
        target.writeMessage();
        System.out.println("");
        target.writeHome();

        System.out.println("\n\nProxied object:");
        proxy.writeMessage();
        proxy.writeHome();
    }

}