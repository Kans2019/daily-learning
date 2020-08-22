package com.study.august.thinkinJava.serialtest;

import java.io.*;

/**
 * @description: ExPerson
 * @date: 2020/8/20
 * @author: likanghai
 */
public class Person implements Externalizable {

    private String name;

    private int age;

    private int level;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        //out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readObject().toString();
        //this.age = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.out"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.out"));
        oos.writeObject(new Person("whiltes", 23));
        Person person = (Person)ois.readObject();
        System.out.println(person);
    }
}
