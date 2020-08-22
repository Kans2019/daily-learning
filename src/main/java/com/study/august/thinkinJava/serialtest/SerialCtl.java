package com.study.august.thinkinJava.serialtest;

import com.sun.corba.se.impl.ior.ObjectAdapterIdNumber;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.io.*;

/**
 * @description: SerialCtl
 * @date: 2020/8/20
 * @author: likanghai
 */
public class SerialCtl implements Serializable {

    String a;

    transient  String b;

    public SerialCtl(String a, String b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString(){
        return a + "\n"  + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();;
        //stream.writeObject(b);
    }


    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();;
        // b = (String)stream.readObject();

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("lim","linn");
        FileOutputStream fileOutputStream = new FileOutputStream("sc.out");
        ObjectOutputStream o = new ObjectOutputStream(fileOutputStream);
        o.writeObject(sc);

        FileInputStream fileInputStream = new FileInputStream("sc.out");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        SerialCtl sc2 = (SerialCtl)in.readObject();
        System.out.println(sc2);

    }
}


//通过私有的writeObject和readObject方法，对于非transient修饰的属性可以直接调用defaulteWriteObject，
//如果要对transient修饰的属性进行序列化，则需要去通过代码手动序列化
