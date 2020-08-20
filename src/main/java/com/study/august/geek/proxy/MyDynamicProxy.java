package com.study.august.geek.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * @description: MyDynamicProxy
 * @date: 2020/8/6
 * @author: likanghai
 */
public class MyDynamicProxy {
    @Test
    public void testProxy(){
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),
                HelloImpl.class.getInterfaces(), handler);
        proxyHello.sayHello();
    }

    @Test
    public void testBoxing(){
        int a = 5;
        Integer.valueOf(a);
        //Short.valueOf();
        char c = '\u0000';
        char b = '\u007F';
        System.out.println(c);
        System.out.println(b);

    }

    private final AtomicLong counter = new AtomicLong();
    @Test
    public void Counter(){

        counter.incrementAndGet();
    }

    private volatile long counter1;
    @Test
    public void CompactCounter(){

    }
}
