package com.study.august.thinkinJava.serialtest;

/**
 * @description: TestException
 * @date: 2020/8/24
 * @author: likanghai
 */
public class TestException {
    public static void main(String[] args) {
        try{
            System.out.println(toInt("a"));
        }catch (Exception e){
            System.out.println(e.toString());
        }

        System.out.println("ok");
    }



    private static int toInt(String s){
        return Integer.parseInt(s);
    }
}
