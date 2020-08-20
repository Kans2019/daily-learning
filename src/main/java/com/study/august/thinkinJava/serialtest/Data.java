package com.study.august.thinkinJava.serialtest;

import org.junit.Test;

import java.io.*;

/**
 * @description: Data
 * @date: 2020/8/19
 * @author: likanghai
 */
public class Data implements Serializable {

    private int i;

    private transient String a;

    public Data(){

    }

    Data(int x) {
        this.i = x;
    }

    Data(int x, String str) {
        this.i = x;
        this.a = str;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("data.out");
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            Data data = (Data) in.readObject();
            System.out.println(" data = " + data);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wirteObject() {
        Data data = new Data(1, "abc");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("data.out");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
