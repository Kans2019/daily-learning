package com.study.august.geek.proxy;

/**
 * @description: HelloImpl
 * @date: 2020/8/6
 * @author: likanghai
 */
public class HelloImpl implements Hello{

    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }
}
