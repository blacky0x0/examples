package com.example;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class TestApp {

    public static void main(final String[] args) throws Exception {

        MessageWriter target = new MessageWriter();

        Pointcut pointCut = new SimpleStaticPointcut();
        Advice advice = new MessageDecorator();
        Advisor advisor = new DefaultPointcutAdvisor(pointCut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        //proxyFactory.addAdvice(new MessageDecorator());
        //proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();

        System.out.println("\n\nNo proxy:");
        target.writeMessage();
        System.out.println("");
        target.writeHome();

        System.out.println("\n\nProxied object:");
        proxy.writeMessage();
        System.out.println("");
        proxy.writeHome();
    }

}