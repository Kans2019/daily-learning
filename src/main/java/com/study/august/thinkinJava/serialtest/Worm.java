package com.study.august.thinkinJava.serialtest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @description: Worm
 * @date: 2020/8/19
 * @author: likanghai
 */
public class Worm implements Serializable {
    private static int r(){
        return (int)(Math.random() * 10);
    }

    private Data[] d = {
            new Data(r()), new Data(r()), new Data(r())
    };

    private Worm next;

    private char c;

    Worm(int i , char x){
        System.out.println("Worm constructor:" + i);
        c = x;
        if(--i > 0){
            next = new Worm(i, (char)(x+1));
        }
    }

    Worm(){
        System.out.println("Default constructor");
    }

    @Override
    public String toString(){
        String s = ":" + c + "(";
        for(int i = 0; i < d.length; i++){
            s += d[i].toString();
        }
        s += ")";
        if(next != null){
            s += next.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Worm w = new Worm(2, 'a');
        System.out.println("w = " + w);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
            out.writeObject("Worm storage");
            out.writeObject(w);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}


