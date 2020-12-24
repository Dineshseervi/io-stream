package com.learn.io.stream.file;

import java.io.*;

public class ObjectStreamExample {
    public static class Person implements Serializable {
        public String name = null;
        public int    age  =   0;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file=new File("/Users/dineshseervi/Desktop/Doc/workDoc/2020_nov/iostream/src/main/resources/object.txt");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(file));

        /*Person person = new Person();
        person.name = "Jakob Jenkov";
        person.age  = 40;*/

        /*Person person2 = new Person();
        person2.name = "Dinesh seervi";
        person2.age  = 28;*/
        int count=10;
        while (count>0) {
            Person person = new Person();
            person.name = "Jakob Jenkov";
            person.age  = count;
            objectOutputStream.writeObject(person);
            count--;
        }
        //objectOutputStream.flush();
        objectOutputStream.close();


        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(file));
        int countio=10;
        while(countio>0) {
            Person personRead = (Person) objectInputStream.readObject();
            System.out.println(personRead.name);
            System.out.println(personRead.age);
            countio--;
        }
        objectInputStream.close();
    }
}
